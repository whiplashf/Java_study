package static_;

public class ChildGame {
    int t = 1;
    public static void main(String[] args) {
        Child.n1 = 1;
        System.out.println(Child.n1);
        System.out.println(Child.n1);
//        Child child = new Child("jak");
//        child.join();
//        child.count++;
//
//        Child child1 = new Child("ros");
//        child1.count++;
//        child1.join();
//
//        System.out.println();
//        for (int i = 0; i < args.length; i++) {
//            System.out.println(args[i]);
//        }

    }

    public void cry(){
        System.out.println("crying...");
    }
}


class Child {
    private String name;
    public static int count= 0;

    public static int n1 = getN1();

    static {
        System.out.println("静态代码块被调用...");
    }

    public static int getN1() {
        System.out.println("静态方法getN1被调用");
        return 100;
    }


    public Child(String name) {
        this.name = name;
    }
    public void join() {
        System.out.println(name+"join the game...");
    }
}