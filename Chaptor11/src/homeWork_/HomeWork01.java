package homeWork_;

import java.util.*;

public class HomeWork01 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("jack",500);
        map.put("tom",1200);
        map.put("smith",2900);
        System.out.println(map);
        map.put("jack",2600);

        Set nameSet = map.keySet();
        for (Object  o : nameSet) {
            Integer i = (Integer) (map.get(o));
            map.put(o,i+100);
        }
        System.out.println(map);

        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person());
        TreeMap treeMap = new TreeMap();
        treeMap.put(1, new Person());


    }
}

