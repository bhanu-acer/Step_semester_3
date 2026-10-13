public class PiggyBank {
    private int savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        } else {
            System.out.println("Withdrawal rejected");
        }
    }

    public int getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank bank = new PiggyBank("PB-1");

        bank.deposit(100);
        System.out.println("Savings: " + bank.getSavings());

        bank.withdraw(30);
        System.out.println("Savings: " + bank.getSavings());

        bank.withdraw(500);
        System.out.println("Savings: " + bank.getSavings());
    }
}