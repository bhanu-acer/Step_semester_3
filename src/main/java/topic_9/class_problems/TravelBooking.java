import java.util.*;

abstract class Travel {
    static final double BOOKING_FEE = 50;

    double distance;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double fare();

    double total() {
        return fare() + BOOKING_FEE;
    }
}

class Bus extends Travel {

    Bus(double distance) {
        super(distance);
    }

    double fare() {
        return distance * 2;
    }
}

class Train extends Travel {

    Train(double distance) {
        super(distance);
    }

    double fare() {
        return distance * 1.5;
    }
}

class Flight extends Travel {

    Flight(double distance) {
        super(distance);
    }

    double fare() {
        return 2500 + distance * 4;
    }
}

public class TravelBooking {

    static Travel createTravel(
        String mode,
        double distance
    ) {

        if (mode.equals("BUS")) {
            return new Bus(distance);
        }

        if (mode.equals("TRAIN")) {
            return new Train(distance);
        }

        return new Flight(distance);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String mode = sc.next();
            double distance = sc.nextDouble();

            Travel travel =
                createTravel(mode, distance);

            double total = travel.total();

            System.out.printf(
                "%s: %.2f%n",
                mode,
                total
            );
        }

        sc.close();
    }
}