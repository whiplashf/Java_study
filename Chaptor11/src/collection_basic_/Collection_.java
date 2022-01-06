package collection_basic_;
/* 
    Author: whiplash
    Date: 2021/11/30 10:45
*/


import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Collection_ {
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Book1("三国演义", "罗贯中", 10.1));
        col.add(new Book1("小李飞刀", "古龙", 5.1));
        col.add(new Book1("红楼梦", "曹雪芹", 34.6));


        List list = new ArrayList();
        list.add("张三丰");
        list.add("贾宝玉");

// 1. add
        list.add(1, "韩顺平"); //在index = 1的位置插入一个对象,后面顺移
        System.out.println("list=" + list);

// 2. boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list2 = new ArrayList();
        list2.add("jack");
        list2.add("tom");
        list.addAll(1, list2);
        System.out.println("list=" + list);

        System.out.println(col);

    }
}
class Book1 {
    private String name;
    private String author;
    private double price;

    public Book1(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}