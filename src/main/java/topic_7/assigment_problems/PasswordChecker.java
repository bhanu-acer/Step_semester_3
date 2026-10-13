public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        } else if (password.length() <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker first = new PasswordChecker("abcd");
        PasswordChecker second = new PasswordChecker("abcdefgh");
        PasswordChecker third = new PasswordChecker("abcdefghijkl");

        System.out.println(first.getStrength());
        System.out.println(second.getStrength());
        System.out.println(third.getStrength());
    }
}