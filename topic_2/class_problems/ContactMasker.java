import java.util.*;

public class ContactMasker {

    static String maskValue(String value) {
        if (value.length() != 10) {
            return "Invalid contact value";
        }
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                return "Invalid contact value";
            }
        }
        String lastFour = value.substring(6);
        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.insert(6, "-");
        masked.append(lastFour);
        return masked.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter contact value: ");
        String value = sc.nextLine();
        System.out.println(maskValue(value));
        sc.close();
    }
}
