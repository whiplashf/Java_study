/*
    Author: whiplash
    Date: 2021/11/29 11:50
*/


import java.util.Arrays;
import java.util.Comparator;

public class ArrayExercise01 {
    public static void main(String[] args) {
        Book[] books = new Book[3];
        books[0] = new Book("水浒传2",124.6);
        books[1] = new Book("西游记",100);
        books[2] = new Book("瓶梅",108);

        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if(o1.price<o2.price) return 1; // 降序
                else return -1;
            }
        });
        // Arrays.toString 会把数组中每个对象toString后放到一个StringBuffer中，再调用它的toString方法
        System.out.println("按价格从高到低排序为："+Arrays.toString(books));

        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.name.length()-o2.name.length(); // 书名从短到长排序
            }
        });
        System.out.println("按书名从短到长排序为："+Arrays.toString(books));
    }

}
class Book {
    String name;
    double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setAddress(String str) {

    }
}
