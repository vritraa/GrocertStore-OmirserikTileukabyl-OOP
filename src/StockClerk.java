public class StockClerk extends Staff {
    private int shelvesStocked;
    private String assignedSection;

    public StockClerk(String name, double salary, String assignedSection) {
        // Использование super() для вызова конструктора родителя
        super(name, "Stock Clerk", salary);
        this.shelvesStocked = 0;
        setAssignedSection(assignedSection);
    }

    // Валидация в сеттере
    public void setAssignedSection(String section) {
        if (section == null || section.trim().isEmpty()) {
            throw new IllegalArgumentException("Section cannot be empty");
        }
        this.assignedSection = section;
    }

    // @Override методы
    @Override
    public void work() {
        System.out.println(name + " is stocking shelves in " + assignedSection + " section...");
        shelvesStocked++;
    }

    @Override
    public double calculateBonus() {
        // Бонус 7% + дополнительные за полки
        double baseBonus = super.calculateBonus(); // Используем родительский метод
        double stockingBonus = shelvesStocked * 0.25;
        return baseBonus + stockingBonus;
    }

    // Дополнительные специфичные методы
    public void stockShelves(int count) {
        shelvesStocked += count;
        System.out.println(name + " stocked " + count + " shelves");
    }

    public void checkExpiryDates() {
        System.out.println(name + " is checking expiry dates in " + assignedSection);
    }

    public int getShelvesStocked() { return shelvesStocked; }
    public String getAssignedSection() { return assignedSection; }

    @Override
    public String getInfo() {
        return String.format("[Stock Clerk] %s (ID: %s) - Section: %s - Shelves Stocked: %d",
                name, id, assignedSection, shelvesStocked);
    }

    // Ещё один @Override метод
    @Override
    public String toString() {
        return getInfo();
    }
}