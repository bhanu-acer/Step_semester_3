import java.util.*;
abstract class Vehicle {
    int hours;
    Vehicle(int hours) { this.hours = hours; }
    abstract double charge();
}
class Bike extends Vehicle {
    Bike(int hours) { super(hours); }
    double charge() { return hours * 10; }
}
class Car extends Vehicle {
    Car(int hours) { super(hours); }
    double charge() {
        if (hours == 1) return 30;
        return 30 + (hours - 1) * 20;
    }
}
class Truck extends Vehicle {
    Truck(int hours) { super(hours); }
    double charge() {
        double amount = hours * 50;
        if (amount < 100) return 100;
        return amount;
    }
}
public class PC {
    static Vehicle createVehicle(String type, int hours) {
        if (type.equals("BIKE")) return new Bike(hours);
        if (type.equals("CAR")) return new Car(hours);
        return new Truck(hours);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next(); int hours = sc.nextInt();
            Vehicle vehicle = createVehicle(type, hours);
            double charge = vehicle.charge();
            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}