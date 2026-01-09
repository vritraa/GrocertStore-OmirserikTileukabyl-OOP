public class StockClerk extends Staff {
    private int shelvesStocked;
    private String assignedSection;

    public StockClerk(String name, double salary, String assignedSection) {
        super(name, "Stock Clerk", salary);
        this.shelvesStocked = 0;
        setAssignedSection(assignedSection);
    }

    public void setAssignedSection(String section) {
        if (section == null || section.trim().isEmpty()) {
            throw new IllegalArgumentException("Section cannot be empty");
        }
        this.assignedSection = section;
    }

    @Override
    public void work() {
        System.out.println(name + " is stocking shelves in " + assignedSection + " section...");
        shelvesStocked++;
    }

    @Override
    public double calculateBonus() {
        double baseBonus = super.calculateBonus();
        double stockingBonus = shelvesStocked * 0.25;
        return baseBonus + stockingBonus;
    }

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

    @Override
    public String toString() {
        return getInfo();
    }
}
