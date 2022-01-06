package homework9;
/* 
    Author: whiplash
    Date: 2021/11/24 0:32
*/


public class HW1 {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        Frock frock = new Frock();
        Frock frock2 = new Frock();
        System.out.println(frock.getSerialNum());
        System.out.println(frock2.getSerialNum());
    }
}

class Frock {
    private static int currentNum=100000;
    private int serialNum;
    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }

    public Frock() {
        serialNum = getNextNum();
    }

    public int getSerialNum() {
        return serialNum;
    }
}