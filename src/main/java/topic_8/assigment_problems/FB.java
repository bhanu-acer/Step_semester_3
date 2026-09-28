import java.util.*;
abstract class Employee {
    String name; double salary;
    Employee(String name, double salary) { this.name = name; this.salary = salary; }
    abstract double bonus();
}
class FullTime extends Employee {
    FullTime(String name, double salary) { super(name, salary); }
    double bonus() { return salary * 0.10; }
}
class PartTime extends Employee {
    PartTime(String name, double salary) { super(name, salary); }
    double bonus() { return salary * 0.05; }
}
class Intern extends Employee {
    Intern(String name, double salary) { super(name, salary); }
    double bonus() { return 2000; }
}
public class FB {
    static Employee createEmployee(String type, String name, double salary) {
        if (type.equals("FULLTIME")) return new FullTime(name, salary);
        if (type.equals("PARTTIME")) return new PartTime(name, salary);
        return new Intern(name, salary);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next(); String name = sc.next(); double salary = sc.nextDouble();
            Employee employee = createEmployee(type, name, salary);
            double bonus = employee.bonus();
            System.out.printf("%s: %.2f%n", name, bonus);
            total += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}