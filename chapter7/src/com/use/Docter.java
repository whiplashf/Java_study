package com.use;

import javax.print.Doc;
import java.util.Objects;

public class Docter {
    private String name;
    private int age;
    private String job;
    private String gender;
    private double sal;

    public Docter(String name, int age, String job, String gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Docter docter = (Docter) o;
        return age == docter.age && Double.compare(docter.sal, sal) == 0 && Objects.equals(name, docter.name) && Objects.equals(job, docter.job) && Objects.equals(gender, docter.gender);
    }


    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
