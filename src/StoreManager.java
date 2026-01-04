public class StoreManager extends Staff {
    private int departmentCount;
    private boolean inventoryManaged;

    public StoreManager(String name, double salary) {
        // Использование super() для вызова конструктора родителя
        super(name, "Store Manager", salary);
        this.departmentCount = 5; // По умолчанию 5 отделов
        this.inventoryManaged = true;
    }

    // @Override методы
    @Override
    public void work() {
        System.out.println(name + " is managing store operations and supervising staff...");
        inventoryManaged = true;
    }

    @Override
    public double calculateBonus() {
        // Бонус 15% + дополнительные за управление
        double baseBonus = super.calculateBonus(); // Используем родительский метод
        double managementBonus = departmentCount * 100;
        return baseBonus + managementBonus;
    }

    // Дополнительные специфичные методы
    public void addDepartment() {
        departmentCount++;
        System.out.println(name + " added a new department. Total: " + departmentCount);
    }

    public void conductMeeting() {
        System.out.println(name + " is conducting a staff meeting...");
    }

    public void manageInventory() {
        inventoryManaged = true;
        System.out.println(name + " has managed the inventory");
    }

    public int getDepartmentCount() { return departmentCount; }
    public boolean isInventoryManaged() { return inventoryManaged; }

    @Override
    public String getInfo() {
        return String.format("[Manager] %s (ID: %s) - Departments: %d - Inventory Managed: %s",
                name, id, departmentCount, inventoryManaged ? "Yes" : "No");
    }

    // Ещё один @Override метод
    @Override
    public String toString() {
        return getInfo();
    }
}