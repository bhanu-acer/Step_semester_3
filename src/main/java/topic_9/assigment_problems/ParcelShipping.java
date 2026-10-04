import java.util.*;

interface Insurable {
    double insurance();
}

abstract class Parcel {
    double weight;
    double value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double charge();
}

class Standard extends Parcel {
    Standard(double weight, double value) {
        super(weight, value);
    }

    double charge() {
        return 40 + weight * 10;
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double value) {
        super(weight, value);
    }

    double charge() {
        return 80 + weight * 15;
    }

    public double insurance() {
        return value * 0.02;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double value) {
        super(weight, value);
    }

    double charge() {
        return 40 + weight * 10 + 50;
    }

    public double insurance() {
        return value * 0.02;
    }
}

public class ParcelShipping {

    static Parcel create(String type, double weight, double value) {
        if (type.equals("STANDARD"))
            return new Standard(weight, value);

        if (type.equals("EXPRESS"))
            return new Express(weight, value);

        return new Fragile(weight, value);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel parcel = create(type, weight, value);

            double charge = parcel.charge();
            double insurance = 0;

            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).insurance();
            }

            double total = charge + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}