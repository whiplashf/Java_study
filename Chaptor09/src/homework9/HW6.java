package homework9;
/* 
    Author: whiplash
    Date: 2021/11/24 10:33
*/


public class HW6 {
    public static void main(String[] args) {
        Person person = new Person("唐僧", VehiclesFactory.getBoat());
    }
}

interface Vehicles {
    String work();
}

class VehiclesFactory {
    static class Horse implements Vehicles {
        @Override
        public String work() {
            return "is riding a horse...";
        }
    }

    static class Boat implements  Vehicles {
        @Override
        public String work() {
            return "is riding a boat...";
        }
    }

    public static Vehicles getHorse() {
        Horse horse = new Horse();
        return horse;
    }
    public static Vehicles getBoat() {
        Boat boat = new Boat();
        return boat;
    }
}

class Person {
    private String name;
    private Vehicles Vehicles;

    public Person(String name, homework9.Vehicles vehicles) {
        this.name = name;
        Vehicles = vehicles;
        System.out.println(name+" "+vehicles.work());
    }
}