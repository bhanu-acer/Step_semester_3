import java.util.*;
abstract class Room {
    int units;
    Room(int units) { this.units = units; }
    abstract double bill();
}
class Single extends Room {
    Single(int units) { super(units); }
    double bill() { return units * 8; }
}
class Shared extends Room {
    int occupants;
    Shared(int units, int occupants) { super(units); this.occupants = occupants; }
    double bill() { return (units * 6.0) / occupants; }
}
class AC extends Room {
    AC(int units) { super(units); }
    double bill() { return units * 10 + 200; }
}
public class EB {
    static Room createRoom(String type, int units, int occupants) {
        if (type.equals("SINGLE")) return new Single(units);
        if (type.equals("SHARED")) return new Shared(units, occupants);
        return new AC(units);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            int occupants = 0;
            if (type.equals("SHARED")) occupants = sc.nextInt();
            Room room = createRoom(type, units, occupants);
            double bill = room.bill();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}