import java.util.*;

interface BusUser {
    double transportFee();
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuition();

    double totalFee() {
        return tuition();
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double tuition() {
        return 40000;
    }

    public double transportFee() {
        return 12000;
    }

    double totalFee() {
        return tuition() + transportFee();
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double tuition() {
        return 40000;
    }

    double totalFee() {
        return tuition() + 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    double tuition() {
        return 20000;
    }

    public double transportFee() {
        return 12000;
    }

    double totalFee() {
        return tuition() + transportFee();
    }
}

public class CollegeFee {

    static Student create(String type, String name) {
        if (type.equals("DAY_SCHOLAR"))
            return new DayScholar(name);

        if (type.equals("HOSTELLER"))
            return new Hosteller(name);

        return new Scholar(name);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student = create(type, name);

            double fee = student.totalFee();

            System.out.printf("%s: %.2f%n", name, fee);

            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);

        sc.close();
    }
}