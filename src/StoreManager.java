public class StoreManager extends Staff {
    private int departmentCount;
    private boolean inventoryManaged;

    public StoreManager(String name, double salary) {
        super(name, "Store Manager", salary);
        this.departmentCount = 5;
        this.inventoryManaged = true;
    }

    @Override
    public void work() {
        System.out.println(name + " is managing store operations and supervising staff...");
        inventoryManaged = true;
    }

    @Override
    public double calculateBonus() {
        double baseBonus = super.calculateBonus();
        double managementBonus = departmentCount * 100;
        return baseBonus + managementBonus;
    }

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

    @Override
    public String toString() {
        return getInfo();
    }
}
