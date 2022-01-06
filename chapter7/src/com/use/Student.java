package com.use;

public class Student extends Person {
    public String id;
    private double score;

    public Student(String name, int age, String id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public String say() {
//        return super.say()+" id是"+id+" 分数是"+score;
        return " id是"+id+" 分数是"+score;

    }

    public void sleep() {
        System.out.println(getName()+"正在睡觉zzzzzzz");
    }
}
