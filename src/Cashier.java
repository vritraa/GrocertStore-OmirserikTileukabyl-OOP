public class Cashier extends Staff {
    private int transactionsProcessed;
    private double dailyRevenue;

    public Cashier(String name, double salary) {
        // Использование super() для вызова конструктора родителя
        super(name, "Cashier", salary);
        this.transactionsProcessed = 0;
        this.dailyRevenue = 0;
    }

    // @Override методы
    @Override
    public void work() {
        System.out.println(name + " is scanning items and processing payments...");
        transactionsProcessed++;
    }

    @Override
    public double calculateBonus() {
        // Бонус 10% + дополнительные за транзакции
        double baseBonus = super.calculateBonus(); // Используем родительский метод
        double transactionBonus = transactionsProcessed * 0.50;
        return baseBonus + transactionBonus;
    }

    // Дополнительные специфичные методы
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

    // Ещё один @Override метод
    @Override
    public String toString() {
        return getInfo();
    }
}