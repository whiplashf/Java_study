/*
    Author: whiplash
    Date: 2021/11/28 14:54
*/


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = {1,6,4,-5,0,999};
        bubble1(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer)o1;
                int i2 = (Integer)o2;
                return i1-i2; // 升序
//                return i2-i1; // 降序
            }
        });
        System.out.println(Arrays.toString(arr));
        int[] arr2 = Arrays.copyOf(arr, 5);
        Arrays.fill(arr2, 88);
        List asList = Arrays.asList(1,5,3);
        System.out.println(asList);
        System.out.println(asList.getClass());

    }
    public static void bubble1(int[] arr, Comparator c) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(c.compare(arr[j],arr[j+1]) > 0) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}

