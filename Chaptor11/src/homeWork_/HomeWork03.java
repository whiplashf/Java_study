package homeWork_;

import java.util.Comparator;
import java.util.TreeSet;

public class HomeWork03 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                return ((Person)o1).id-((Person)o2).id;
            }
        });
        Person p1 = new Person(100, "AA");//ok
        Person p2 = new Person(50, "BB");//ok
        treeSet.add(p1);
        treeSet.add(p2);
        p2.id = 2;
        System.out.println(treeSet);

        treeSet.remove(new Person(3, "BB")); // 这里的remove是如何查找的呢？按照compare顺序？
        System.out.println(treeSet);

        treeSet.add(new Person(2, "BB"));
        System.out.println(treeSet);

        treeSet.add(new Person(49, "BB"));
        System.out.println(treeSet);

        treeSet.add(new Person(99, "BB"));
        System.out.println(treeSet);


    }
}
