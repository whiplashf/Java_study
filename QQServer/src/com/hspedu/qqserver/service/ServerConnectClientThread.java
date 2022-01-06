package com.hspedu.qqserver.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author 韩顺平
 * @version 1.0
 * 该类的一个对象和某个客户端保持通信
 * <p>
 * 客户端连接用户的 线程。 保持监听，并对收到的信息进行反应。
 */
public class ServerConnectClientThread extends Thread {

    private Socket socket;
    private String userId;//连接到服务端的用户id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() { //这里线程处于run的状态，可以发送/接收消息

        while (true) {
            try {
                System.out.println("服务端和客户端" + userId + " 保持通信，读取数据...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //后面会使用message, 根据message的类型，做相应的业务处理
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    //客户端要在线用户列表
                    /*
                    在线用户列表形式 100  200  紫霞仙子
                     */
                    System.out.println(message.getSender() + " 要在线用户列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    //返回message
                    //构建一个Message 对象，返回给客户端
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser);
                    message2.setGetter(message.getSender());
                    //返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);

                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //根据message获取getter id, 然后在得到对应先线程
                    ServerConnectClientThread serverConnectClientThread =
                            ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    //得到对应socket的对象输出流，将message对象转发给指定的客户端

                    if (serverConnectClientThread != null) {
                        // 注：这里如果给不在线的用户发，就会出现空指针异常
                        ObjectOutputStream oos =
                                new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                        oos.writeObject(message);
                    } else {  //转发，提示如果客户不在线，可以保存到数据库，这样就可以实现离线留言
                        StoreUnreadMessages.add(message.getGetter(), message);
                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    //需要遍历 管理线程的集合，把所有的线程的socket得到，然后把message进行转发即可
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();

                    Iterator<String> iterator = QQServer.getValidUsers().keySet().iterator(); // 遍历所有注册用户
                    while (iterator.hasNext()) {

                        //取出所有注册用户id
                        String userId = iterator.next().toString();

                        if (userId.equals(message.getSender())) continue; //排除群发消息的这个用户
                        if (hm.get(userId) != null) { //在线的
                            //进行转发message
                            ObjectOutputStream oos =
                                    new ObjectOutputStream(hm.get(userId).getSocket().getOutputStream());
                            oos.writeObject(message);
                        } else { // 不在线的
                            StoreUnreadMessages.add(userId, message);
                        }

                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {

                    ServerConnectClientThread serverConnectClientThread =
                            ManageClientThreads.getServerConnectClientThread(message.getGetter());

                    if (serverConnectClientThread != null) {
                        //根据getter id 获取到对应的线程，将message对象转发
                        ObjectOutputStream oos =
                                new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                        //转发
                        oos.writeObject(message);
                    } else {
                        StoreUnreadMessages.add(message.getGetter(), message); // 文件存进去，也是一样的
                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {//客户端退出

                    System.out.println(message.getSender() + " 退出");
                    //将这个客户端对应线程，从集合删除.
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    socket.close();//关闭连接
                    //退出线程
                    break;

                } else {
                    System.out.println("其他类型的message , 暂时不处理");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
