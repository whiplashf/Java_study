package homework9;
/* 
    Author: whiplash
    Date: 2021/11/24 0:40
*/


public class HW2 {
    public static void main(String[] args) {

    }
}

interface Computer {
    void work();
}

class Cellphone {
    public void testWork() {
        new Computer(){
            @Override
            public void work() {

            }
        }.work();
    }
}
