package generic_;

import java.util.*;

public class Generic01 {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();
        Student stu1 = new Student("jack", 18);
        Student stu2 = new Student("rose", 18);
        Student stu3 = new Student("emoi", 18);
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);

        for (Student student : students) {
            System.out.println(student);
        }

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        HashMap<String, Student> stringStudentHashMap = new HashMap<>();
        stringStudentHashMap.put(stu1.name,stu1);
        stringStudentHashMap.put(stu2.name,stu2);
        stringStudentHashMap.put(stu3.name,stu3);


        Set<String> keySet = stringStudentHashMap.keySet();
        for (String name : keySet) {
            System.out.println(name);
        }


        Set<Map.Entry<String, Student>> entries = stringStudentHashMap.entrySet();
        for (Map.Entry s : entries) {
            System.out.println(s.getKey()+"-"+s.getValue());
        }


    }
}

class Student {
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
