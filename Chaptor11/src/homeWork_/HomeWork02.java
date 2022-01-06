package homeWork_;

import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

public class HomeWork02 {
    public static void main(String[] args) {
        HashSet set = new HashSet();//ok
        Person p1 = new Person(1001, "AA");//ok
        Person p2 = new Person(1002, "BB");//ok
        set.add(p1);//ok
        set.add(p2);//ok
        p1.name = "CC";
        set.remove(p1); // （1001，CC）哈希值计算出的位置上，找不到p1,因为p1还在原来（1001，AA）的坑里
        System.out.println(set);//2
        set.add(new Person(1001, "CC")); //也就是说，先放进去在修改，是可以存在相同元素的
        System.out.println(set);//3
        set.add(new Person(1001, "AA"));
        System.out.println(set);//4

        
    }
}

class Person {
    public String name;
    public int id;

    public Person() {
    }

    public Person(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

