import java.util.*;
abstract class Transport {
    double distance;
    Transport(double distance) { this.distance = distance; }
    abstract double fare();
}
class Bus extends Transport {
    Bus(double distance) { super(distance); }
    double fare() {
        double amount = 2 + distance * 0.10;
        if (amount > 10) return 10;
        return amount;
    }
}
class Train extends Transport {
    Train(double distance) { super(distance); }
    double fare() { return 3 + distance * 0.15; }
}
class Metro extends Transport {
    double factor;
    Metro(double distance, double factor) { super(distance); this.factor = factor; }
    double fare() { return (1.50 + distance * 0.20) * factor; }
}
public class TF {
    static Transport create(String type, double distance, double factor) {
        if (type.equals("BUS")) return new Bus(distance);
        if (type.equals("TRAIN")) return new Train(distance);
        return new Metro(distance, factor);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next(); double distance = sc.nextDouble();
            double factor = 1;
            if (type.equals("METRO")) factor = sc.nextDouble();
            Transport t = create(type, distance, factor);
            double result = t.fare();
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}