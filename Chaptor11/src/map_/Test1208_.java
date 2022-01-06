package map_;

public class Test1208_ {
    public static void main(String[] args) {
        Object o = new A();
//        System.out.println(ia.name); // 无法访问o的特有属性name
        Ia ia = (Ia)o; // 通过实现的接口 向下转型 会转换成A类？
        A a = (A)o;
        System.out.println(ia.name);
        ia.say();
        System.out.println(a.name);
        System.out.println("ia的运行类型是："+ia.getClass()); // class map_.A
        System.out.println("a的运行类型是："+a.getClass()); // class map_.A
    }
}

interface Ia {
    String name = "jack";
    public void say();
}

class A implements Ia {
    public String name = "jj";

    @Override
    public void say() {
        System.out.println("A is talking...");
    }
}