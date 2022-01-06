package interface_;

interface DB_ {            //项目经理
    int password = 666;
    public void connect(); //连接方法
    public void close();   //关闭连接
}

//A 程序
class MysqlDB implements DB_ {
    @Override
    public void connect() {
        System.out.println("连接mysql");
    }

    @Override
    public void close() {
        System.out.println("关闭mysql");
    }

    public void work() {
        System.out.println("MysqlDB is working...");
    }
}

//B 程序员连接Oracle
class OracleDB implements DB_ {
    @Override
    public void connect() {
        System.out.println("连接oracle");
    }

    @Override
    public void close() {
        System.out.println("关闭oracle");
    }
}

abstract class tiger implements DB_ {}