/*
    Author: whiplash
    Date: 2021/11/30 12:12
*/


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class List_ {
    public static void main(String[] args) {
//        List list1 = new ArrayList();
        List list1 = new LinkedList();
        list1.add(new Book("我不","大冰",30));
        list1.add(new Book("朝花夕拾","鲁迅",20));
        list1.add(new Book("白夜行","村上春树",25));
        list1.add(new Book("机器学习","周志华",9));
        System.out.println(list1);
        for (Object o : list1) {
            System.out.println(o);
        }
        listSort(list1);
        System.out.println("======排序后=========");
        for (Object o : list1) {
//            Book oBook = (Book)o;
//            String format = "名称:%s\t价格:%f\t作者:%s";
//            String info = String.format(format,oBook.name, oBook.price, oBook.author);
            System.out.println(o);
        }
    }
    public static void listSort(List list) {
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-1-i; j++) {
//                if (((Book)list.get(j)).price>((Book)list.get(j+1)).price) {
//                    Book temp = (Book) list.remove(j+1);
//                    list.add(j,temp);
//                }
                Book book1 = (Book)list.get(j);
                Book book2 = (Book)list.get(j+1);
                if(book1.price> book2.price) {
                    list.set(j,book2);
                    list.set(j+1,book1);
                }
            }
        }
    }
    
}
class Book {
    String name;
    String author;
    double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        String format = "名称:%s\t价格:%f\t作者:%s";
        String info = String.format(format,name, price, author);
        return info;
    }
}