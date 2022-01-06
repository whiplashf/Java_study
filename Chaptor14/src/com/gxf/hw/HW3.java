package com.gxf.hw;

/*
    Author: Whiplash
    Date: 2021/12/26 22:19
*/

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class HW3 {
    public static void main(String[] args) throws IOException {
        String path = "f:\\mytemp\\dog.properties";
        Properties properties = new Properties();
        properties.setProperty("name", "tom");
        properties.setProperty("age", "5");
        properties.setProperty("color","red");
        properties.store(new FileWriter(path), null);

        properties.load(new FileReader(path));
        properties.list(System.out);

        Dog dog = new Dog();
        System.out.println(dog);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("f:\\mytemp\\dog.dat"));
        objectOutputStream.writeObject(dog);
        objectOutputStream.close();
    }

    @Test
    public void m1() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f:\\mytemp\\dog.dat"));
        Object dog = ois.readObject();
        System.out.println(dog.getClass());
        System.out.println(dog);
        ois.close();
    }
}

class Dog implements Serializable{

    private String name;
    private int age;
    private String color;

    public Dog() throws IOException{
        String path = "f:\\mytemp\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(path));
        name = properties.getProperty("name");
        age = Integer.parseInt(properties.getProperty("age"));
        color = properties.getProperty("color");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}