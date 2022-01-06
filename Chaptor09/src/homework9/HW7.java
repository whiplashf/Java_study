package homework9;
/* 
    Author: whiplash
    Date: 2021/11/24 14:35
*/


public class HW7 {
    public static void main(String[] args) {
        Car car = new Car(20);
        car.getAir().flow();
        car.setTemperature(50);
        car.getAir().flow();

    }
}

class Car {
    private double temperature;

    class Air {
        public void flow(){
                if (temperature>40){
                    System.out.println("空调制冷中...");
                } else if(temperature<0){
                    System.out.println("空调制热中...");
                } else {
                    System.out.println("== 空调关闭 ==");
                }
        }
    }

    public Car(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Air getAir() {
        return new Air();
    }

}

