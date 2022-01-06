/*
    Author: whiplash
    Date: 2021/11/29 22:28
*/


public class HomeWork3 {
    public static void main(String[] args) {
        String name = " Willian Jeff Clinton ";
//        System.out.println(printName(name));
        System.out.println(name.charAt(1));

        System.out.println(name.trim());
        System.out.println(name);
    }

    public static String printName(String name) {
        String[] arr = name.split(" ");
        return arr[2]+","+arr[0]+" ."+arr[1].substring(0,1);
    }

}
