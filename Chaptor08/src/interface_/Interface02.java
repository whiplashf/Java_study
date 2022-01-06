package interface_;

public class Interface02 {
    public static void main(String[] args) {
    }
}


interface Ib { int x = 1;}
class B { int x = 0; }
class C extends B implements Ib {
    public void printX(){
        System.out.println(Ib.x+" "+super.x);
    }
}
