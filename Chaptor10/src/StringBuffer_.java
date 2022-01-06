/* 
    Author: whiplash
    Date: 2021/11/26 23:35
*/


public class StringBuffer_ {
    public static void main(String[] args) {

        Double d1 = 10.0;
        System.out.println(String.valueOf(d1));
        String str0 = Double.toString(d1);
        System.out.println(str0);
        B.m1();

        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());
        System.out.println(sb);
        System.out.println(sb.indexOf("u"));

        StringBuilder stringBuilder = new StringBuilder();


    }

}
class A {
    public static void m1(){
        System.out.println("fasfsa");
    }
}
class B extends A {

}
