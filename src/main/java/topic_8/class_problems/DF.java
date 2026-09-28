import java.util.*;
abstract class Delivery {
    double weight, distance;
    Delivery(double weight, double distance) { this.weight = weight; this.distance = distance; }
    abstract double fee();
}
class Standard extends Delivery {
    Standard(double weight, double distance) { super(weight, distance); }
    double fee() { return 5 + weight * 0.50 + distance * 0.10; }
}
class Express extends Delivery {
    Express(double weight, double distance) { super(weight, distance); }
    double fee() { return 15 + weight + distance * 0.20; }
}
class International extends Delivery {
    double customs;
    International(double weight, double distance, double customs) { super(weight, distance); this.customs = customs; }
    double fee() { return 25 + weight * 2 + distance * 0.50 + customs; }
}
public class DF {
    static Delivery create(String type, double weight, double distance, double customs) {
        if (type.equals("STANDARD")) return new Standard(weight, distance);
        if (type.equals("EXPRESS")) return new Express(weight, distance);
        return new International(weight, distance, customs);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next(); double weight = sc.nextDouble(); double distance = sc.nextDouble();
            double customs = 0;
            if (type.equals("INTERNATIONAL")) customs = sc.nextDouble();
            Delivery d = create(type, weight, distance, customs);
            double result = d.fee();
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}