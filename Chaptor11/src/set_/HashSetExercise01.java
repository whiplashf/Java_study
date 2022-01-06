package set_;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExercise01 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        System.out.println(hashSet.add(new Employee("jack",18, new Mydate(2019,12,12))));
        System.out.println(hashSet.add(new Employee("jack",18, new Mydate(2019,12,12))));
    }
}

class Employee {
    private String name;
    private int age;
    private Mydate birthday;

    public Employee(String name, int age, Mydate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && name.equals(employee.name) && birthday.equals(employee.birthday);
    }

    // 必须要重写hashCode,让他们的hashCode一致,才能进一步判断equals
    @Override
    public int hashCode() {
        return Objects.hash(name, age, birthday);
    }

}

class Mydate {
    private int year;
    private int month;
    private int day;

    public Mydate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mydate mydate = (Mydate) o;
        return year == mydate.year && month == mydate.month && day == mydate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}