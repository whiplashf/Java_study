/*
    Author: whiplash
    Date: 2021/11/30 22:31
*/


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class ArrayList_ {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1,"jack");

        //使用for给list集合添加 1-10数据
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        //使用for给list集合添加 11-15数据
        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);

        Vector vector = new Vector();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        vector.add(3);

    }
}
