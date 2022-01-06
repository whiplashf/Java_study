package map_;

import java.util.HashMap;

public class HashMapSource01 {
    public static void main(String[] args) {


        HashMap hashMap = new HashMap();
        for(int i = 1; i <= 12; i++) {
            hashMap.put(new A2(i), "hello");
        }

//        hashMap.put("aaa", "bbb");

        System.out.println("hashMap=" + hashMap);//12个 k-v
        hashMap.toString();
    }
}

class A2 {
    private int num;

    public A2(int num) {
        this.num = num;
    }

    //所有的A对象的hashCode都是100
//    @Override
//    public int hashCode() {
//        return 100;
//    }

    @Override
    public String toString() {
        return "\nA{" +
                "num=" + num +
                '}';
    }
}