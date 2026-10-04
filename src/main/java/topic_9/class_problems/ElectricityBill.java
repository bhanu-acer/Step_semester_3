import java.util.*;

abstract class Connection {
    double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double bill();
}

class Home extends Connection {

    Home(double units) {
        super(units);
    }

    double bill() {

        if (units <= 100) {
            return units * 5;
        }

        return (100 * 5) + ((units - 100) * 7);
    }
}

class Shop extends Connection {

    Shop(double units) {
        super(units);
    }

    double bill() {
        return units * 8 + 100;
    }
}

class Factory extends Connection {

    Factory(double units) {
        super(units);
    }

    double bill() {

        double amount = units * 6;

        if (amount < 1000) {
            amount = 1000;
        }

        return amount;
    }
}

public class ElectricityBill {

    static Connection createConnection(
        String type,
        double units
    ) {

        if (type.equals("HOME")) {
            return new Home(units);
        }

        if (type.equals("SHOP")) {
            return new Shop(units);
        }

        return new Factory(units);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double units = sc.nextDouble();

            Connection connection =
                createConnection(type, units);

            double bill = connection.bill();

            System.out.printf(
                "%s: %.2f%n",
                type,
                bill
            );

            total += bill;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}