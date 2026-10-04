import java.util.*;

interface NightService {
    double nightFare(double fare);
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double rate();

    double fare() {
        double amount = km * rate();

        if (amount < 100)
            amount = 100;

        return amount;
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double rate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double rate() {
        return 14;
    }

    public double nightFare(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double rate() {
        return 18;
    }

    public double nightFare(double fare) {
        return fare * 1.20;
    }
}

public class CityCab {

    static Cab create(String type, double km) {
        if (type.equals("MINI"))
            return new Mini(km);

        if (type.equals("SEDAN"))
            return new Sedan(km);

        return new SUV(km);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = create(type, km);

            if (time.equals("NIGHT") &&
                !(cab instanceof NightService)) {

                System.out.println(
                    type + ": night service not available"
                );

                continue;
            }

            double fare = cab.fare();

            if (time.equals("NIGHT")) {
                NightService service = (NightService) cab;
                fare = service.nightFare(fare);
            }

            System.out.printf(
                "%s: %.2f%n",
                type, fare
            );

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}