/*
    Author: whiplash
    Date: 2021/11/29 12:27
*/


import java.math.BigDecimal;
import java.util.Arrays;

public class SystemTest {
    public static void main(String[] args) {
        System.out.println("ok1");
//      0 表示一个状态 , 正常的状态
//        System.exit(0);
        System.out.println("ok2");

        //arraycopy ：复制数组元素，比较适合底层调用，
        // 一般使用Arrays.copyOf完成复制数组

        int[] src={1,2,3};
        int[] dest = new int[3];// dest 当前是 {0,0,0}


        System.arraycopy(src, 0, dest, 0, src.length);
        System.out.println("dest=" + Arrays.toString(dest));//[1, 2, 3]

        BigDecimal bigDecimal = new BigDecimal("1999.11");
        BigDecimal bigDecimal2 = new BigDecimal("3");
        System.out.println(bigDecimal);


    }
}
