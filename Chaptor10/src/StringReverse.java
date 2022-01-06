/*
    Author: whiplash
    Date: 2021/11/29 20:07
*/


import java.util.Arrays;

public class StringReverse {
    public static void main(String[] args) {
//        StringBuilder str = new StringBuilder("abcdef");
        String str = "abcdefghi";
        try {
            System.out.println(reverse(str,-1,str.length()-3));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String reverse(String str, int start, int end){
        if(!(str!=null && start>=0 && end<=str.length() && start<end)) {
            throw new RuntimeException("参数不正确");
        }
        char[] chars = str.toCharArray();
        char temp = ' ';
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}


