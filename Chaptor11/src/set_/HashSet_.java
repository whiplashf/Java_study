package set_;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSet_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < 6; i++) {
            hashSet.add(new B(i));
        }
        for (int i = 1; i <= 7; i++) {
            hashSet.add(new A(i));
        }
    }
}

class Node { //结点, 存储数据, 可以指向下一个结点，从而形成链表
    Object item; //存放数据
    Node next; // 指向下一个结点

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}

class A {
    int i;

    public A(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}
class B {
    int i;

    public B(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        return 110;
    }
}
