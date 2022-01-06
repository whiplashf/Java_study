package map_;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExercise01 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("001", new Employee("jack","001",150));
        map.put("002", new Employee("Ana","002",180));
        map.put("003", new Employee("Domm","003",20));

        System.out.println("---------遍历1---------");
        Set set = map.keySet();
        for (Object key : set) {
            Employee employee = (Employee)(map.get(key));
            if(employee.getSal()>100){
                System.out.println(employee.getName());
            }
        }

        System.out.println("---------遍历2---------");
        Set set1 = map.entrySet();
        for (Object o :set1) {
            Map.Entry entry = (Map.Entry)o;
            Employee employee = (Employee)(entry.getValue());
            if(employee.getSal()>100){
                System.out.println(employee.getName());
            }
        }


    }
}

class Employee {
    private String name;
    private String id;
    private double sal;

    public Employee(String name, String id, double sal) {
        this.name = name;
        this.id = id;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public double getSal() {
        return sal;
    }
}