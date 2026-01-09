public class Cashier extends Staff {
    private int transactionsProcessed;
    private double dailyRevenue;

    public Cashier(String name, double salary) {
        super(name, "Cashier", salary);
        this.transactionsProcessed = 0;
        this.dailyRevenue = 0;
    }

    @Override
    public void work() {
        System.out.println(name + " is scanning items and processing payments...");
        transactionsProcessed++;
    }

    @Override
    public double calculateBonus() {
        double baseBonus = super.calculateBonus();
        double transactionBonus = transactionsProcessed * 0.50;
        return baseBonus + transactionBonus;
    }

    public void processPayment(double amount) {
        dailyRevenue += amount;
        transactionsProcessed++;
        System.out.printf("%s processed payment: $%.2f%n", name, amount);
    }

    public void resetDailyStats() {
        transactionsProcessed = 0;
        dailyRevenue = 0;
        System.out.println(name + "'s daily stats have been reset");
    }

    public int getTransactionsProcessed() { return transactionsProcessed; }
    public double getDailyRevenue() { return dailyRevenue; }

    @Override
    public String getInfo() {
        return String.format("[Cashier] %s (ID: %s) - Transactions: %d - Daily Revenue: $%.2f",
                name, id, transactionsProcessed, dailyRevenue);
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
