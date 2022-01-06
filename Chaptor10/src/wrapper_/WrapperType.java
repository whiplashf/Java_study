package wrapper_;
/* 
    Author: whiplash
    Date: 2021/11/25 14:27
*/


public class WrapperType {
    public static void main(String[] args) {
        int n1 = 199;
        // 手动装箱*2
        Integer integer1 = new Integer(n1);
        Integer integer2 = Integer.valueOf(n1);
        // 手动拆箱
        int n2 = integer1.intValue();

        // 自动装箱
        Integer integer3 = n1; // 底层仍是 Integer.valueOf(n1)
        // 自动拆箱
        int n3 = integer3;     // 底层仍是 intValue()

        Object obj = true? new Integer(1):new Double(2.0);
        System.out.println(obj);

        // String -> 包装类
        String str = "123";
        //方式1
        Integer i1 = Integer.parseInt(str); // 包含了一个自动装箱
        //方式2
        Integer i2 = new Integer(str);

        // 包装类 -> String
        Integer i = 3;
        // 1
        String s1 = i + "";
        // 2
        String s2 = String.valueOf(i);
        // 3 使用包装类的toString方法
        String s3 = i.toString();
    }
}
