import java.util.*;

interface Saver {
    double saverUnits(double units);
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double power();

    double units() {
        return power() * hours / 1000;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double power() {
        return 150;
    }
}

class AC extends Appliance implements Saver {
    AC(double hours) {
        super(hours);
    }

    double power() {
        return 1500;
    }

    public double saverUnits(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double power() {
        return 100;
    }
}

class Washer extends Appliance implements Saver {
    Washer(double hours) {
        super(hours);
    }

    double power() {
        return 500;
    }

    public double saverUnits(double units) {
        return units * 0.75;
    }
}

public class ApplianceEnergy {

    static Appliance create(String type, double hours) {
        if (type.equals("FRIDGE"))
            return new Fridge(hours);

        if (type.equals("AC"))
            return new AC(hours);

        if (type.equals("TV"))
            return new TV(hours);

        return new Washer(hours);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            String mode = "";

            if (sc.hasNextLine()) {
                mode = sc.nextLine().trim();
            }

            boolean saver = mode.equals("SAVER");

            Appliance appliance = create(type, hours);

            if (saver && !(appliance instanceof Saver)) {
                System.out.println(
                    type + ": saver mode not supported"
                );
                continue;
            }

            double units = appliance.units();

            if (saver) {
                Saver s = (Saver) appliance;
                units = s.saverUnits(units);
            }

            double cost = units * 8;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf(
            "Total Cost: %.2f%n",
            totalCost
        );

        sc.close();
    }
}