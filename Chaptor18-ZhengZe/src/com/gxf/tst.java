package com.gxf;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;

import java.nio.charset.StandardCharsets;
import java.util.*;

class tst {
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        System.out.println(i);
        String s = "dingzhen";
        int n = 31 / 10;
        System.out.println(n);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        System.out.println(1 ^ 3);

        StringBuffer stringBuffer = new StringBuffer("Hello,Tom");
// 1. 增 append 直接修改本身
        stringBuffer.append("!").append(">0<");
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.delete(0,1));
        Queue<Integer> q = new LinkedList<>();
        q.offer(3);
        q.offer(4);
        q.offer(q.poll());
        System.out.println(q);

        System.out.println("=====================");
        Deque<Integer> deque = new ArrayDeque<Integer>(8);

        // use add() method to add elements in the deque
        deque.add(25);
        deque.add(30);
        deque.add(35);

        // adding elements using push() method
        deque.push(10);
        deque.push(15);

        System.out.println("Printing Elements after using push operation:");
        for (Integer number : deque) {
            System.out.println("Number = " + number);
        }

        String[] ss = {"+","-"};
        for(String s1 : ss){
            System.out.println(s1!="+");
        }

        Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋喆", "马蓉");
        map.put("刘令博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");
        Set entrySet = map.entrySet();
        System.out.println("----使用EntrySet 的 for增强(第3种)----");
        for (Object entry : entrySet) {
            //向下转型
            //将Object 转成Map.EntryHashMap$Node (调用了Map.Entry接口，但是会转成HashMap$Node运行类型)
            System.out.println(entry.getClass());
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue()); // Map.Entry提供的方法
        }

        Stack stack = new Stack();
        stack.push(null);
        System.out.println(stack.empty());

        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        System.out.println(resList.size());

        String s1 = "good";
        System.out.println(1 + "" + 1 );


    }

}

class tc{
    public static void main(String[] args) {
        System.out.println("can you print this?");
        int a[] = {1,2,3,4};
        int b[] = Arrays.copyOfRange(a, 0,3);
        System.out.println(Arrays.toString(b));
    }
}