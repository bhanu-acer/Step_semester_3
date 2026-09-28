import java.util.*;
import java.time.LocalDate;
abstract class Item {
    String title;
    Item(String title) { this.title = title; }
    abstract LocalDate dueDate();
}
class Book extends Item {
    Book(String title) { super(title); }
    LocalDate dueDate() { return LocalDate.of(2023, 10, 26).plusDays(14); }
}
class DVD extends Item {
    DVD(String title) { super(title); }
    LocalDate dueDate() { return LocalDate.of(2023, 10, 26).plusDays(7); }
}
class Magazine extends Item {
    Magazine(String title) { super(title); }
    LocalDate dueDate() { return LocalDate.of(2023, 10, 26).plusDays(3); }
}
public class LD {
    static Item create(String type, String title) {
        if (type.equals("BOOK")) return new Book(title);
        if (type.equals("DVD")) return new DVD(title);
        return new Magazine(title);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).replace("\"", "");
            Item item = create(type, title);
            System.out.println(item.title + ": " + item.dueDate());
        }
        sc.close();
    }
}