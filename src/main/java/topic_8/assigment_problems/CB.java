import java.util.*;

abstract class Customer {
    double amount;
    Customer(double amount) { this.amount = amount; }
    abstract double finalAmount();
}
class Student extends Customer {
    Student(double amount) { super(amount); }
    double finalAmount() { return amount * 0.90; }
}
class Staff extends Customer {
    Staff(double amount) { super(amount); }
    double finalAmount() { return amount * 0.95; }
}
class Guest extends Customer {
    Guest(double amount) { super(amount); }
    double finalAmount() { return amount + 10; }
}
public class CB {
    static Customer createCustomer(String type, double amount) {
        if (type.equals("STUDENT")) return new Student(amount);
        if (type.equals("STAFF")) return new Staff(amount);
        return new Guest(amount);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Customer customer = createCustomer(type, amount);
            double finalAmount = customer.finalAmount();
            System.out.printf("%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}