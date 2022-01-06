package innerClass_;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        System.out.println("outer01对象的类名："+outer01.getClass());
        outer01.f1();
    }
}

class Outer01 {
    public void f1(){
        I01 i01 = new I01() {
            @Override
            public void work() {
                System.out.println("接口I01的匿名内部实现i01 is working...");
            }
        };
        System.out.println("匿名内部类的隐藏类名："+i01.getClass());
        i01.work();

        Father father = new Father("jack"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        System.out.println("father对象的运行类型："+father.getClass());
        father.test();
    }
}

interface I01 {
    public void work();
}

class Father {
    public Father (String name) {}
    public void test() {}
}