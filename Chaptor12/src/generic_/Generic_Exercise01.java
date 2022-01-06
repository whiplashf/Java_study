package generic_;

import java.util.ArrayList;
import java.util.Comparator;

public class Generic_Exercise01 {
    public static void main(String[] args) {

        MyDate myDate1 = new MyDate(12,9,1998);
        MyDate myDate2 = new MyDate(2,19,1998);
        MyDate myDate3 = new MyDate(3,15,1998);
        MyDate myDate4 = new MyDate(3,13,1998);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("ack",1000,myDate1));
        employees.add(new Employee("fix",20000,myDate2));
        employees.add(new Employee("bouis",20,myDate3));
        employees.add(new Employee("louis",20,myDate4));

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(!(o1 instanceof Employee && o2 instanceof Employee)){
                    System.out.println("类型不正确");
                    return 0;
                }
                MyDate b1 = o1.getBirthday();
                MyDate b2 = o2.getBirthday();
                if(o1.getName().equals(o2.getName())) {
                    return b1.compareTo(b2);
                } else return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println(employees);
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}

class MyDate implements Comparable<MyDate>{
    private int month;
    private int day;
    private int year;

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    @Override
    public int compareTo(MyDate d) {
        if(getYear()==d.getYear()){
            if(getMonth()== d.getMonth()) {
                    return getDay()-d.getDay(); // 省去一步判断，直接返回相减值
            } else return getMonth() - d.getMonth();
        } else return getYear()-d.getYear();
    }

    @Override
    public String toString() {
        return year+"-"+month+"-"+day;
    }

    public int getMonth() {
        return month;
    }


    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

}
