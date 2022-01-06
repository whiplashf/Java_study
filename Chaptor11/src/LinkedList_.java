import java.util.Iterator;
import java.util.LinkedList;

public class LinkedList_ {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("第一个节点");
        linkedList.add("第2个节点");
        linkedList.add("第3个节点");

        linkedList.remove(1);
        linkedList.set(1,88);
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            
        }
        
    }
}

class Node {
    public Object item; //真正存放数据
    public Node next; //指向后一个结点
    public Node pre; //指向前一个结点
    public Node(Object name) {
        this.item = name;
    }
    public String toString() {
        return "Node name=" + item;
    }
}
