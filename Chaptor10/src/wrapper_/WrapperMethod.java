package wrapper_;
/* 
    Author: whiplash
    Date: 2021/11/25 16:05
*/


public class WrapperMethod {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); //False

        Integer m = 1; //底层Integer.valueOf(1); -> 阅读源码
        Integer n = 1;//底层Integer.valueOf(1);
        System.out.println(m == n); //T

        Integer x = -128;//底层Integer.valueOf(1);
        Integer y = -128;//底层Integer.valueOf(1);
        System.out.println(x == y);//False

        System.out.println(x==-128);

        String a = "hsp";                      //a指向常量池的"hsp"
        String b =new String("edu");   //b指向堆中对象
        String c = a+b;
        String d = "hspedu";
        String e = a+"edu";
        System.out.println(c==d);
        System.out.println(e==d);

    }
}
