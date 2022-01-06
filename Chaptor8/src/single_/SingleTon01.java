package single_;

import interface_.Ia;

public class SingleTon01 {
    public static void main(String[] args) {
        System.out.println(GirlFriend.t);
        System.out.println(Ia.n1);
    }
}

class GirlFriend {

    static public int t=1;

    private String name;
    final private static GirlFriend gf = new GirlFriend("Ana");

    static {
        System.out.println("金泰代码块被调用……");
    }

    private GirlFriend(String name) {

        this.name = name;
    }

    public static GirlFriend getInstance() {
        return gf;
    }
}
