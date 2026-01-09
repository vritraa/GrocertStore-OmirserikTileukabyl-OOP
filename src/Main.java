import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Staff> staffMembers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static Product milk, eggs, bread, apples, cheese, chicken, rice, pasta, tomatoes, potatoes, coffee, tea, sugar, oil;

    public static void main(String[] args) {
        System.out.println("=== Grocery Store Management System ===\n");
        initializeData();
        runMenuSystem();
        scanner.close();
    }

    private static void initializeData() {
        milk = new Product("Fresh Milk", 550.0, "Dairy", true);
        eggs = new Product("Eggs", 700.0, "Dairy", true);
        bread = new Product("Whole Wheat Bread", 350.0, "Bakery", true);
        apples = new Product("Organic Apples", 1200.0, "Fruits", true);
        cheese = new Product("Cheddar Cheese", 1800.0, "Dairy", true);
        chicken = new Product("Chicken Breast", 2500.0, "Meat", true);
        rice = new Product("Basmati Rice", 1200.0, "Grains", true);
        pasta = new Product("Spaghetti", 850.0, "Grains", true);
        tomatoes = new Product("Fresh Tomatoes", 450.0, "Vegetables", true);
        potatoes = new Product("Potatoes", 300.0, "Vegetables", true);
        coffee = new Product("Arabica Coffee", 3500.0, "Beverages", true);
        tea = new Product("Green Tea", 1200.0, "Beverages", true);
        sugar = new Product("White Sugar", 600.0, "Baking", true);
        oil = new Product("Sunflower Oil", 1500.0, "Cooking", true);

        products.addAll(Arrays.asList(milk, eggs, bread, apples, cheese, chicken, rice, pasta, tomatoes, potatoes, coffee, tea, sugar, oil));

        Customer customer1 = new Customer("Aizhan", "Zhamal", "+77011234567", 75);
        Customer customer2 = new Customer("Bakhytzhan", "Alimov", "+77029876543");
        Customer customer3 = new Customer();
        customer3.setName("Mary");
        customer3.setSurname("Ayaru");
        customer3.setPhoneNumber("+77008889900");
        customer3.setLoyaltyPoints(200);

        customers.addAll(Arrays.asList(customer1, customer2, customer3));

        Staff genericStaff = new Staff("Alex Johnson", "General Assistant", 2500.0);
        Cashier cashier1 = new Cashier("Sarah Miller", 3000.0);
        StoreManager manager1 = new StoreManager("Robert Chen", 5000.0);
        StockClerk clerk1 = new StockClerk("Mike Wilson", 2800.0, "Dairy");

        staffMembers.add(genericStaff);
        staffMembers.add(cashier1);
        staffMembers.add(manager1);
        staffMembers.add(clerk1);

        System.out.println("✓ System initialized");
        System.out.println("Products: " + products.size());
        System.out.println("Customers: " + customers.size());
        System.out.println("Staff: " + staffMembers.size() + "\n");
    }

    private static void runMenuSystem() {
        boolean exit = false;

        while (!exit) {
            displayMainMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1: manageProducts(); break;
                case 2: manageCustomers(); break;
                case 3: manageTransactions(); break;
                case 4: manageStaff(); break;
                case 5: viewSystemSummary(); break;
                case 6: demonstratePolymorphism(); break;
                case 0: exit = true; System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice!");
            }

            if (!exit && choice != 0) {
                pause();
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Manage Products");
        System.out.println("2. Manage Customers");
        System.out.println("3. Manage Transactions");
        System.out.println("4. Manage Staff");
        System.out.println("5. System Summary");
        System.out.println("6. Polymorphism Demo");
        System.out.println("0. Exit");
    }

    private static void manageProducts() {
        boolean back = false;

        while (!back) {
            System.out.println("\n=== PRODUCT MANAGEMENT ===");
            System.out.println("1. View All Products");
            System.out.println("2. Add New Product");
            System.out.println("3. Update Product");
            System.out.println("4. Apply Discount");
            System.out.println("5. Restock Product");
            System.out.println("0. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1: viewAllProducts(); break;
                case 2: addNewProduct(); break;
                case 3: updateProduct(); break;
                case 4: applyProductDiscount(); break;
                case 5: restockProduct(); break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void viewAllProducts() {
        System.out.println("\n=== ALL PRODUCTS ===");
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                System.out.printf("%2d. %-25s $%-8.2f %-12s %s%n",
                        i + 1, p.getName(), p.getPrice(),
                        "(" + p.getCategory() + ")",
                        p.isAvailable() ? "✓ Available" : "✗ Out of stock");
            }
        }
    }

    private static void addNewProduct() {
        System.out.println("\n--- Add New Product ---");
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        double price = readDouble("Enter product price: ");
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        Product newProduct = new Product(name, price, category, true);
        products.add(newProduct);
        System.out.println("✓ Product added!");
    }

    private static void updateProduct() {
        viewAllProducts();
        if (products.isEmpty()) return;

        int index = readInt("Select product number to update: ") - 1;
        if (index < 0 || index >= products.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Product product = products.get(index);
        System.out.println("\nCurrent: " + product);

        System.out.print("Enter new name (press Enter to keep): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) product.setName(name);

        System.out.print("Enter new price (0 to keep): ");
        double price = readDouble("");
        if (price > 0) product.setPrice(price);

        System.out.print("Enter new category (press Enter to keep): ");
        String category = scanner.nextLine();
        if (!category.isEmpty()) product.setCategory(category);

        System.out.println("✓ Product updated!");
    }

    private static void applyProductDiscount() {
        viewAllProducts();
        if (products.isEmpty()) return;

        int index = readInt("Select productt number for discount: ") - 1;
        if (index < 0 || index >= products.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        double discount = readDouble("Enter discount percentage: ");
        Product product = products.get(index);
        System.out.printf("Price before: $%.2f%n", product.getPrice());
        product.applyDiscount(discount);
        System.out.printf("Price after: $%.2f%n", product.getPrice());
        System.out.println("✓ Discount applied!");
    }

    private static void restockProduct() {
        viewAllProducts();
        if (products.isEmpty()) return;

        int index = readInt("Select product number to restock: ") - 1;
        if (index < 0 || index >= products.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Product product = products.get(index);
        System.out.println("Current: " + (product.isAvailable() ? "Available" : "Out of stock"));
        int quantity = readInt("Enter restock quantity: ");
        product.restock(quantity);
        System.out.println("✓ Product restocked!");
    }

    private static void manageCustomers() {
        boolean back = false;

        while (!back) {
            System.out.println("\n=== CUSTOMER MANAGEMENT ===");
            System.out.println("1. View All Customers");
            System.out.println("2. Add New Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Add Loyalty Points");
            System.out.println("5. Use Loyalty Points");
            System.out.println("6. Check VIP Status");
            System.out.println("0. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1: viewAllCustomers(); break;
                case 2: addNewCustomer(); break;
                case 3: updateCustomer(); break;
                case 4: addCustomerPoints(); break;
                case 5: useCustomerPoints(); break;
                case 6: checkVIPStatus(); break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void viewAllCustomers() {
        System.out.println("\n=== ALL CUSTOMERS ===");
        if (customers.isEmpty()) {
            System.out.println("No customers.");
        } else {
            for (int i = 0; i < customers.size(); i++) {
                Customer c = customers.get(i);
                System.out.printf("%d. %s %s (ID: %s)%n",
                        i + 1, c.getName(), c.getSurname(), c.getCustomerId());
                System.out.printf("   Phone: %s, Points: %d, VIP: %s%n",
                        c.getPhoneNumber(), c.getLoyaltyPoints(), c.isVIP() ? "Yes" : "No");
            }
        }
    }

    private static void addNewCustomer() {
        System.out.println("\n--- Add New Customer ---");
        System.out.print("Enter first name: ");
        String name = scanner.nextLine();
        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        Customer newCustomer = new Customer(name, surname, phone);
        customers.add(newCustomer);
        System.out.println("✓ Customer added! ID: " + newCustomer.getCustomerId());
    }

    private static void updateCustomer() {
        viewAllCustomers();
        if (customers.isEmpty()) return;

        int index = readInt("Select customer number to update: ") - 1;
        if (index < 0 || index >= customers.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Customer customer = customers.get(index);
        System.out.print("Enter new name (press Enter to keep): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) customer.setName(name);

        System.out.print("Enter new surname (press Enter to keep): ");
        String surname = scanner.nextLine();
        if (!surname.isEmpty()) customer.setSurname(surname);

        System.out.print("Enter new phone (press Enter to keep): ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) customer.setPhoneNumber(phone);

        System.out.println("✓ Customer updated!");
    }

    private static void addCustomerPoints() {
        viewAllCustomers();
        if (customers.isEmpty()) return;

        int index = readInt("Select customer number: ") - 1;
        if (index < 0 || index >= customers.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        int points = readInt("Enter points to add: ");
        Customer customer = customers.get(index);
        System.out.printf("Points before: %d%n", customer.getLoyaltyPoints());
        customer.addLoyaltyPoints(points);
        System.out.printf("Points after: %d%n", customer.getLoyaltyPoints());
        if (customer.isVIP()) {
            System.out.println("🎉 VIP! Discount: " + customer.getLoyaltyDiscount() + "%");
        }
    }

    private static void useCustomerPoints() {
        viewAllCustomers();
        if (customers.isEmpty()) return;

        int index = readInt("Select customer number: ") - 1;
        if (index < 0 || index >= customers.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Customer customer = customers.get(index);
        System.out.printf("Available points: %d%n", customer.getLoyaltyPoints());
        int points = readInt("Enter points to use: ");
        boolean success = customer.useLoyaltyPoints(points);
        if (success) {
            System.out.println("✓ Points used!");
            System.out.printf("Remaining: %d%n", customer.getLoyaltyPoints());
        } else {
            System.out.println("✗ Not enough points.");
        }
    }

    private static void checkVIPStatus() {
        viewAllCustomers();
        if (customers.isEmpty()) return;

        int index = readInt("Select customer number: ") - 1;
        if (index < 0 || index >= customers.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Customer customer = customers.get(index);
        System.out.println("\n=== VIP STATUS ===");
        customer.displayCustomerInfo();
        System.out.printf("VIP: %s%n", customer.isVIP() ? "YES 🎉" : "No");
        System.out.printf("Discount: %d%%%n", customer.getLoyaltyDiscount());
    }

    private static void manageTransactions() {
        boolean back = false;

        while (!back) {
            System.out.println("\n=== TRANSACTION MANAGEMENT ===");
            System.out.println("1. View All Transactions");
            System.out.println("2. Create New Transaction");
            System.out.println("3. Complete Transaction");
            System.out.println("4. Cancel Transaction");
            System.out.println("0. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1: viewAllTransactions(); break;
                case 2: createNewTransaction(); break;
                case 3: completeTransaction(); break;
                case 4: cancelTransaction(); break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void viewAllTransactions() {
        System.out.println("\n=== ALL TRANSACTIONS ===");
        if (transactions.isEmpty()) {
            System.out.println("No transactions.");
        } else {
            for (int i = 0; i < transactions.size(); i++) {
                Transaction t = transactions.get(i);
                System.out.printf("%d. %s - %s - $%.2f - Status: %s%n",
                        i + 1, t.getTransactionId(), t.getCustomerName(),
                        t.getTotalAmount(), t.getStatus());
            }
        }
    }

    private static void createNewTransaction() {
        System.out.println("\n--- Create New Transaction ---");
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
            return;
        }
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        viewAllCustomers();
        int customerIndex = readInt("Select customer number: ") - 1;
        if (customerIndex < 0 || customerIndex >= customers.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Customer selectedCustomer = customers.get(customerIndex);
        List<String> selectedItems = new ArrayList<>();
        boolean addingItems = true;
        double totalAmount = 0;

        while (addingItems) {
            viewAllProducts();
            System.out.println("0. Finish selection");
            int productIndex = readInt("Select product number: ") - 1;
            if (productIndex == -1) {
                addingItems = false;
            } else if (productIndex >= 0 && productIndex < products.size()) {
                Product selectedProduct = products.get(productIndex);
                if (selectedProduct.isAvailable()) {
                    selectedItems.add(selectedProduct.getName());
                    totalAmount += selectedProduct.getPrice();
                    System.out.println("Added: " + selectedProduct.getName());
                } else {
                    System.out.println("Out of stock!");
                }
            } else {
                System.out.println("Invalid product number!");
            }
        }

        if (selectedItems.isEmpty()) {
            System.out.println("Transaction cancelled.");
            return;
        }

        if (selectedCustomer.isVIP()) {
            double discount = selectedCustomer.getLoyaltyDiscount();
            double discountAmount = totalAmount * discount / 100;
            totalAmount -= discountAmount;
            System.out.printf("VIP discount %.0f%%: -$%.2f%n", discount, discountAmount);
        }

        Transaction transaction = new Transaction(
                selectedCustomer.getName() + " " + selectedCustomer.getSurname(),
                selectedItems,
                totalAmount,
                "Pending"
        );
        transactions.add(transaction);

        int pointsEarned = (int)(totalAmount / 100);
        selectedCustomer.addLoyaltyPoints(pointsEarned);

        System.out.println("\n✓ Transaction created!");
        System.out.println("ID: " + transaction.getTransactionId());
        System.out.printf("Total: $%.2f%n", totalAmount);
        System.out.println("Points earned: " + pointsEarned);
    }

    private static void completeTransaction() {
        viewAllTransactions();
        if (transactions.isEmpty()) return;

        int index = readInt("Select transaction to complete: ") - 1;
        if (index < 0 || index >= transactions.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Transaction transaction = transactions.get(index);
        transaction.completeOrder();
        System.out.println("✓ Transaction completed!");
    }

    private static void cancelTransaction() {
        viewAllTransactions();
        if (transactions.isEmpty()) return;

        int index = readInt("Select transaction to cancel: ") - 1;
        if (index < 0 || index >= transactions.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Transaction transaction = transactions.get(index);
        transaction.cancelOrder();
        System.out.println("✓ Transaction cancelled!");
    }

    private static void manageStaff() {
        boolean back = false;

        while (!back) {
            System.out.println("\n=== STAFF MANAGEMENT ===");
            System.out.println("1. View All Staff");
            System.out.println("2. Add General Staff");
            System.out.println("3. Add Cashier");
            System.out.println("4. Add Store Manager");
            System.out.println("5. Add Stock Clerk");
            System.out.println("6. Make Staff Work");
            System.out.println("7. Calculate Bonuses");
            System.out.println("8. Show Staff Types");
            System.out.println("0. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1: viewAllStaff(); break;
                case 2: addGeneralStaff(); break;
                case 3: addCashier(); break;
                case 4: addStoreManager(); break;
                case 5: addStockClerk(); break;
                case 6: makeStaffWork(); break;
                case 7: calculateStaffBonuses(); break;
                case 8: showStaffTypes(); break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void viewAllStaff() {
        System.out.println("\n=== ALL STAFF ===");
        if (staffMembers.isEmpty()) {
            System.out.println("No staff members.");
        } else {
            for (int i = 0; i < staffMembers.size(); i++) {
                Staff staff = staffMembers.get(i);
                System.out.printf("%2d. %s%n", i + 1, staff);
            }
        }
    }

    private static void addGeneralStaff() {
        System.out.println("\n--- Add General Staff ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter position: ");
        String position = scanner.nextLine();
        double salary = readDouble("Enter salary: ");
        try {
            Staff staff = new Staff(name, position, salary);
            staffMembers.add(staff);
            System.out.println("✓ General staff added!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addCashier() {
        System.out.println("\n--- Add Cashier ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        double salary = readDouble("Enter salary: ");
        try {
            Cashier cashier = new Cashier(name, salary);
            staffMembers.add(cashier);
            System.out.println("✓ Cashier added!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addStoreManager() {
        System.out.println("\n--- Add Store Manager ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        double salary = readDouble("Enter salary: ");
        try {
            StoreManager manager = new StoreManager(name, salary);
            staffMembers.add(manager);
            System.out.println("✓ Store Manager added!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addStockClerk() {
        System.out.println("\n--- Add Stock Clerk ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        double salary = readDouble("Enter salary: ");
        System.out.print("Enter assigned section: ");
        String section = scanner.nextLine();
        try {
            StockClerk clerk = new StockClerk(name, salary, section);
            staffMembers.add(clerk);
            System.out.println("✓ Stock Clerk added!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void makeStaffWork() {
        System.out.println("\n=== STAFF WORK ===");
        if (staffMembers.isEmpty()) {
            System.out.println("No staff members.");
            return;
        }
        for (Staff staff : staffMembers) {
            System.out.print(staff.getName() + ": ");
            staff.work();
        }
    }

    private static void calculateStaffBonuses() {
        System.out.println("\n=== BONUSES ===");
        if (staffMembers.isEmpty()) {
            System.out.println("No staff members.");
            return;
        }
        for (Staff staff : staffMembers) {
            double bonus = staff.calculateBonus();
            System.out.printf("%s: Bonus = $%.2f%n", staff.getName(), bonus);
        }
    }

    private static void showStaffTypes() {
        System.out.println("\n=== STAFF TYPES ===");
        if (staffMembers.isEmpty()) {
            System.out.println("No staff members.");
            return;
        }
        int general = 0, cashier = 0, manager = 0, clerk = 0;
        for (Staff staff : staffMembers) {
            if (staff instanceof Cashier) {
                cashier++;
                System.out.println("✓ " + staff.getName() + " is a [Cashier]");
            } else if (staff instanceof StoreManager) {
                manager++;
                System.out.println("✓ " + staff.getName() + " is a [Store Manager]");
            } else if (staff instanceof StockClerk) {
                clerk++;
                System.out.println("✓ " + staff.getName() + " is a [Stock Clerk]");
            } else {
                general++;
                System.out.println("✓ " + staff.getName() + " is [General Staff]");
            }
        }
        System.out.println("\n=== SUMMARY ===");
        System.out.println("General: " + general);
        System.out.println("Cashiers: " + cashier);
        System.out.println("Managers: " + manager);
        System.out.println("Clerks: " + clerk);
        System.out.println("Total: " + staffMembers.size());
    }

    private static void viewSystemSummary() {
        System.out.println("\n=== SYSTEM SUMMARY ===");
        System.out.println("Products: " + products.size());
        System.out.println("Customers: " + customers.size());
        System.out.println("Transactions: " + transactions.size());
        System.out.println("Staff: " + staffMembers.size());

        int cashiers = 0, managers = 0, clerks = 0, general = 0;
        for (Staff staff : staffMembers) {
            if (staff instanceof Cashier) cashiers++;
            else if (staff instanceof StoreManager) managers++;
            else if (staff instanceof StockClerk) clerks++;
            else general++;
        }
        System.out.println("  - Cashiers: " + cashiers);
        System.out.println("  - Managers: " + managers);
        System.out.println("  - Clerks: " + clerks);
        System.out.println("  - General: " + general);

        long vipCount = customers.stream().filter(Customer::isVIP).count();
        System.out.println("VIP Customers: " + vipCount);

        double totalRevenue = transactions.stream().mapToDouble(Transaction::getTotalAmount).sum();
        System.out.printf("Total Revenue: $%.2f%n", totalRevenue);
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n=== POLYMORPHISM DEMO ===");
        System.out.println("1. One ArrayList<Staff> stores all types:");
        viewAllStaff();

        System.out.println("\n2. Polymorphic work() calls:");
        if (!staffMembers.isEmpty()) {
            for (Staff staff : staffMembers) {
                System.out.print("   ");
                staff.work();
            }
        }

        System.out.println("\n3. Different calculateBonus():");
        if (!staffMembers.isEmpty()) {
            for (Staff staff : staffMembers) {
                double bonus = staff.calculateBonus();
                System.out.printf("   %s: $%.2f bonus%n", staff.getName(), bonus);
            }
        }

        System.out.println("\n4. Using instanceof:");
        if (!staffMembers.isEmpty()) {
            for (Staff staff : staffMembers) {
                String type = "General Staff";
                if (staff instanceof Cashier) type = "Cashier";
                else if (staff instanceof StoreManager) type = "Store Manager";
                else if (staff instanceof StockClerk) type = "Stock Clerk";
                System.out.printf("   %s is a [%s]%n", staff.getName(), type);
            }
        }

        System.out.println("\n✓ All polymorphism concepts demonstrated!");
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Enter a valid number!");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Enter a valid number!");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    private static void pause() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
}