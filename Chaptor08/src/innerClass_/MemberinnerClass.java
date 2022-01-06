package innerClass_;

public class MemberinnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        Outer02.Inner02 inner02 = new Outer02.Inner02();
    }


}

class Outer02 {
    static class Inner02{
        void say() {
            System.out.println("123");
        }
    }
    void use() {
    }
}