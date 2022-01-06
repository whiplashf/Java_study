package set_;

import java.lang.reflect.Array;
import java.util.*;

public class TreeSet_ {
    public static void main(String[] args) {

        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //下面 调用String的 compareTo方法进行字符串大小比较
                //如果老韩要求加入的元素，按照长度大小排序
                //return ((String) o2).compareTo((String) o1);
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        //添加数据.
        treeSet.add("jack");
        treeSet.add("tom");//3
        treeSet.add("sp");
        treeSet.add("a");
        treeSet.add("abc");//3
        System.out.println(treeSet);

        ArrayList arrayList = new ArrayList();
        arrayList.add("");
        arrayList.add("");
        System.out.println(arrayList.size());
        System.out.println(arrayList);
        int[] arr1 = {};
        int[] arr2 = null;
        System.out.println(arr1+" "+arr1.length);
        System.out.println(arr2);
    }
}


