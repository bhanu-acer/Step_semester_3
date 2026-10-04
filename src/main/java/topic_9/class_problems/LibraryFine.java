import java.util.*;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double fine();
}

class Book extends LibraryItem {

    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return daysLate * 2;
    }
}

class DVD extends LibraryItem {

    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {

        double amount = daysLate * 5;

        if (amount > 50) {
            amount = 50;
        }

        return amount;
    }
}

class Magazine extends LibraryItem {

    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return daysLate;
    }
}

public class LibraryFine {

    static LibraryItem createItem(
        String type,
        String title,
        int daysLate
    ) {

        if (type.equals("BOOK")) {
            return new Book(title, daysLate);
        }

        if (type.equals("DVD")) {
            return new DVD(title, daysLate);
        }

        return new Magazine(title, daysLate);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            LibraryItem item =
                createItem(type, title, daysLate);

            double fine = item.fine();

            System.out.printf(
                "%s: %.2f%n",
                item.title,
                fine
            );

            total += fine;
        }

        System.out.printf(
            "Total Fines: %.2f%n",
            total
        );

        sc.close();
    }
}