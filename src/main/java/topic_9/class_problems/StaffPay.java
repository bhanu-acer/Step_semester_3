import java.util.*;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double pay();
}

class FullTime extends Staff {
    double salary;

    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double pay() {
        return salary;
    }
}

class Hourly extends Staff {
    double hours;
    double rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double pay() {

        if (hours <= 40) {
            return hours * rate;
        }

        double overtime = hours - 40;

        return (40 * rate) + (overtime * rate * 1.5);
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double pay() {
        return stipend;
    }
}

public class StaffPay {

    static Staff createStaff(
        String type,
        String name,
        double a,
        double b
    ) {

        if (type.equals("FULLTIME")) {
            return new FullTime(name, a);
        }

        if (type.equals("HOURLY")) {
            return new Hourly(name, a, b);
        }

        return new Intern(name, a);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            double a = sc.nextDouble();
            double b = 0;

            if (type.equals("HOURLY")) {
                b = sc.nextDouble();
            }

            Staff staff = createStaff(type, name, a, b);

            double pay = staff.pay();

            System.out.printf(
                "%s: %.2f%n",
                staff.name,
                pay
            );

            total += pay;
        }

        System.out.printf(
            "Total Payroll: %.2f%n",
            total
        );

        sc.close();
    }
}