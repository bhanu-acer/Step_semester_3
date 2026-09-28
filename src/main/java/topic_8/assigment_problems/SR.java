import java.util.*;
import java.time.LocalDate;
abstract class Plan {
    LocalDate startDate;
    Plan(LocalDate startDate) { this.startDate = startDate; }
    abstract LocalDate renewalDate();
}
class Basic extends Plan {
    Basic(LocalDate startDate) { super(startDate); }
    LocalDate renewalDate() { return startDate.plusDays(30); }
}
class Standard extends Plan {
    Standard(LocalDate startDate) { super(startDate); }
    LocalDate renewalDate() { return startDate.plusDays(90); }
}
class Premium extends Plan {
    Premium(LocalDate startDate) { super(startDate); }
    LocalDate renewalDate() { return startDate.plusDays(365); }
}
public class SR {
    static Plan createPlan(String type, LocalDate startDate) {
        if (type.equals("BASIC")) return new Basic(startDate);
        if (type.equals("STANDARD")) return new Standard(startDate);
        return new Premium(startDate);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next(); String name = sc.next(); String date = sc.next();
            LocalDate startDate = LocalDate.parse(date);
            Plan plan = createPlan(type, startDate);
            System.out.println(name + ": " + plan.renewalDate());
        }
        sc.close();
    }
}