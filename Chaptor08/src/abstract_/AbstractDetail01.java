package abstract_;

import java.awt.*;

public class AbstractDetail01 {
    public static void main(String[] args) {
        new A("A").caculate();
        new B("B").caculate();
    }
}

abstract class Template {
    String name;

    public Template(String name) {
        this.name = name;
    }

    public void caculate() {
        long start = System.currentTimeMillis();
        job(); // 使用了动态绑定机制
        long end = System.currentTimeMillis();
        System.out.println(name+"运行了"+(end-start));
    }

    abstract public void job();

}

class A extends Template {

    public A(String name) {
        super(name);
    }

    public void job() {
        long num=0;
        for (int i = 0; i < 1000000; i++) {
            num+=i;
        }
    }

}

class B extends Template{

    public B(String name) {
        super(name);
    }

    public void job() {
        long num = 1;
        for (int i = 1; i < 100000; i++) {
            num*=i;
        }
    }
}