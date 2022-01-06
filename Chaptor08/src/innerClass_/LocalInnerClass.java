package innerClass_;

public class LocalInnerClass {

    public static void main(String[] args) {
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.m2();
        System.out.println("外部的哈希="+localInnerClass);
        System.out.println(localInnerClass.getClass());
    }

    private int n1 = 100;
    private void m1(){
        System.out.println("m1被调用");
    }

    private void m2(){
        class innerClass01 {
            private int n1 = 2;
            public void f1(){
                System.out.println("n1="+LocalInnerClass.this.n1);
                System.out.println("LocalInnerClass的哈希="+LocalInnerClass.this);
                m1();
            }
        }
        class innerClass02 extends innerClass01 {}
        innerClass01 innerClass01 = new innerClass01();
        innerClass01.f1();
        System.out.println("普通方法中的重名调用父类n1="+this.n1);

    }
}
