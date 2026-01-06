import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Staff> staffMembers = new ArrayList<>(); // НОВОЕ: для полиморфизма

    private static Scanner scanner = new Scanner(System.in);

    // Тестовые данные продуктов
    private static Product milk, eggs, bread, apples, cheese, chicken, rice, pasta, tomatoes, potatoes, coffee, tea, sugar, oil;

    public static void main(String[] args) {
        System.out.println("=== Grocery Store Management System ===");
        System.out.println("This project is about Grocery Store Management System, it helps buying groceries, getting discount, getting more loyal points if you are VIP customer and etc.");
        System.out.println("Now with Staff Management and Polymorphism!");
        System.out.println();

        // Инициализация системы
        initializeData();

        // Запуск меню
        runMenuSystem();

        scanner.close();
    }

    private static void initializeData() {
        System.out.println("=== INITIALIZING SYSTEM DATA ===");

        // Создание продуктов
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

        // Добавляем в коллекцию
        products.addAll(Arrays.asList(milk, eggs, bread, apples, cheese, chicken, rice, pasta, tomatoes, potatoes, coffee, tea, sugar, oil));

        // Создание клиентов
        Customer customer1 = new Customer("Aizhan", "Zhamal", "+77011234567", 75);
        Customer customer2 = new Customer("Bakhytzhan", "Alimov", "+77029876543");
        Customer customer3 = new Customer();
        customer3.setName("Mary");
        customer3.setSurname("Ayaru");
        customer3.setPhoneNumber("+77008889900");
        customer3.setLoyaltyPoints(200);

        customers.addAll(Arrays.asList(customer1, customer2, customer3));

        // НОВОЕ: Инициализация сотрудников для демонстрации полиморфизма
        Staff genericStaff = new Staff("Alex Johnson", "General Assistant", 2500.0);
        Cashier cashier1 = new Cashier("Sarah Miller", 3000.0);
        StoreManager manager1 = new StoreManager("Robert Chen", 5000.0);
        StockClerk clerk1 = new StockClerk("Mike Wilson", 2800.0, "Dairy");

        // Добавляем всех в один полиморфный список
        staffMembers.add(genericStaff);
        staffMembers.add(cashier1);
        staffMembers.add(manager1);
        staffMembers.add(clerk1);

        System.out.println("✓ System initialized with " + products.size() + " products");
        System.out.println("✓ System initialized with " + customers.size() + " customers");
        System.out.println("✓ System initialized with " + staffMembers.size() + " staff members");
        System.out.println();
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
                case 4: manageStaff(); break; // НОВОЕ: Управление сотрудниками
                case 5: viewSystemSummary(); break;
                case 6: demonstratePolymorphism(); break; // НОВОЕ: Демонстрация полиморфизма
                case 7: runOriginalDemo(); break; // Ваш оригинальный демо-код
                case 0:
                    exit = true;
                    System.out.println("Thank you for using Grocery Store Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
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
        System.out.println("4. Manage Staff (NEW with Polymorphism)");
        System.out.println("5. View System Summary");
        System.out.println("6. Demonstrate Polymorphism");
        System.out.println("7. Run Original Demo");
        System.out.println("0. Exit");
    }

    // === Управление продуктами ===
    private static void manageProducts() {
        boolean back = false;

        while (!back) {
            System.out.println("\n=== PRODUCT MANAGEMENT ===");
            System.out.println("1. View All Products");
            System.out.println("2. Add New Product");
            System.out.println("3. Update Product");
            System.out.println("4. Apply Discount");
            System.out.println("5. Check Product Availability");
            System.out.println("6. Restock Product");
            System.out.println("0. Back to Main Menu");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1: viewAllProducts(); break;
                case 2: addNewProduct(); break;
                case 3: updateProduct(); break;
                case 4: applyProductDiscount(); break;
                case 5: checkProductAvailability(); break;
                case 6: restockProduct(); break;
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
                        i + 1,
                        p.getName(),
                        p.getPrice(),
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
        System.out.println("✓ Product added successfully!");
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
        System.out.println("\nCurrent product: " + product);

        System.out.print("Enter new name (press Enter to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            product.setName(name);
        }

        System.out.print("Enter new price (0 to keep current): ");
        double price = readDouble("");
        if (price > 0) {
            product.setPrice(price);
        }

        System.out.print("Enter new category (press Enter to keep current): ");
        String category = scanner.nextLine();
        if (!category.isEmpty()) {
            product.setCategory(category);
        }

        System.out.println("✓ Product updated successfully!");
    }

    private static void applyProductDiscount() {
        viewAllProducts();
        if (products.isEmpty()) return;

        int index = readInt("Select product number for discount: ") - 1;

        if (index < 0 || index >= products.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        double discount = readDouble("Enter discount percentage (e.g., 10 for 10%): ");
        Product product = products.get(index);

        System.out.printf("Price before discount: $%.2f%n", product.getPrice());
        product.applyDiscount(discount);
        System.out.printf("Price after discount: $%.2f%n", product.getPrice());
        System.out.println("✓ Discount applied!");
    }

    private static void checkProductAvailability() {
        viewAllProducts();
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
        System.out.println("Current status: " + (product.isAvailable() ? "Available" : "Out of stock"));

        int quantity = readInt("Enter restock quantity: ");
        product.restock(quantity);
        System.out.println("✓ Product restocked!");
        System.out.println("New status: " + (product.isAvailable() ? "Available" : "Out of stock"));
    }

    // === Управление клиентами ===
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
            System.out.println("7. View Customer Info");
            System.out.println("0. Back to Main Menu");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1: viewAllCustomers(); break;
                case 2: addNewCustomer(); break;
                case 3: updateCustomer(); break;
                case 4: addCustomerPoints(); break;
                case 5: useCustomerPoints(); break;
                case 6: checkVIPStatus(); break;
                case 7: viewCustomerInfo(); break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void viewAllCustomers() {
        System.out.println("\n=== ALL CUSTOMERS ===");
        if (customers.isEmpty()) {
            System.out.println("No customers registered.");
        } else {
            for (int i = 0; i < customers.size(); i++) {
                Customer c = customers.get(i);
                System.out.printf("%d. %s %s (ID: %s)%n",
                        i + 1,
                        c.getName(),
                        c.getSurname(),
                        c.getCustomerId());
                System.out.printf("   Phone: %s, Points: %d, VIP: %s%n",
                        c.getPhoneNumber(),
                        c.getLoyaltyPoints(),
                        c.isVIP() ? "Yes" : "No");
            }
        }
    }

    private static void addNewCustomer() {
        System.out.println("\n--- Add New Customer ---");
        System.out.print("Enter first name: ");
        String name = scanner.nextLine();

        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        Customer newCustomer = new Customer(name, surname, phone);
        customers.add(newCustomer);
        System.out.println("✓ Customer added successfully! ID: " + newCustomer.getCustomerId());
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
        System.out.println("\nCurrent customer:");
        customer.displayCustomerInfo();

        System.out.print("Enter new name (press Enter to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            customer.setName(name);
        }

        System.out.print("Enter new surname (press Enter to keep current): ");
        String surname = scanner.nextLine();
        if (!surname.isEmpty()) {
            customer.setSurname(surname);
        }

        System.out.print("Enter new phone (press Enter to keep current): ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) {
            customer.setPhoneNumber(phone);
        }

        System.out.println("✓ Customer updated successfully!");
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
        System.out.println("✓ Points added!");

        if (customer.isVIP()) {
            System.out.println("🎉 This customer is now a VIP! Discount: " + customer.getLoyaltyDiscount() + "%");
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
            System.out.println("✓ Points used successfully!");
            System.out.printf("Remaining points: %d%n", customer.getLoyaltyPoints());
        } else {
            System.out.println("✗ Failed to use points. Not enough points available.");
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
        System.out.println("\n=== VIP STATUS CHECK ===");
        customer.displayCustomerInfo();
        System.out.printf("VIP Status: %s%n", customer.isVIP() ? "YES 🎉" : "No");
        System.out.printf("Loyalty Discount: %d%%%n", customer.getLoyaltyDiscount());
        System.out.printf("Points needed for VIP: %d%n", Math.max(0, 10000 - customer.getLoyaltyPoints()));
    }

    private static void viewCustomerInfo() {
        viewAllCustomers();
        if (customers.isEmpty()) return;

        int index = readInt("Select customer number: ") - 1;

        if (index < 0 || index >= customers.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Customer customer = customers.get(index);
        System.out.println("\n=== CUSTOMER INFORMATION ===");
        customer.displayCustomerInfo();
        System.out.println("Contact Info: " + customer.getContactInfo());
    }

    // === Управление транзакциями ===
    private static void manageTransactions() {
        boolean back = false;

        while (!back) {
            System.out.println("\n=== TRANSACTION MANAGEMENT ===");
            System.out.println("1. View All Transactions");
            System.out.println("2. Create New Transaction");
            System.out.println("3. Complete Transaction");
            System.out.println("4. Cancel Transaction");
            System.out.println("5. Process Transaction");
            System.out.println("6. Apply Discount to Transaction");
            System.out.println("7. View Receipt");
            System.out.println("0. Back to Main Menu");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1: viewAllTransactions(); break;
                case 2: createNewTransaction(); break;
                case 3: completeTransaction(); break;
                case 4: cancelTransaction(); break;
                case 5: processTransaction(); break;
                case 6: applyTransactionDiscount(); break;
                case 7: viewTransactionReceipt(); break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void viewAllTransactions() {
        System.out.println("\n=== ALL TRANSACTIONS ===");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (int i = 0; i < transactions.size(); i++) {
                Transaction t = transactions.get(i);
                System.out.printf("%d. %s - %s - $%.2f - Status: %s%n",
                        i + 1,
                        t.getTransactionId(),
                        t.getCustomerName(),
                        t.getTotalAmount(),
                        t.getStatus());
            }
        }
    }

    private static void createNewTransaction() {
        System.out.println("\n--- Create New Transaction ---");

        if (customers.isEmpty()) {
            System.out.println("No customers available. Please add customers first.");
            return;
        }

        if (products.isEmpty()) {
            System.out.println("No products available. Please add products first.");
            return;
        }

        // Выбор клиента
        viewAllCustomers();
        int customerIndex = readInt("Select customer number: ") - 1;

        if (customerIndex < 0 || customerIndex >= customers.size()) {
            System.out.println("Invalid customer selection!");
            return;
        }

        Customer selectedCustomer = customers.get(customerIndex);

        // Выбор продуктов
        List<String> selectedItems = new ArrayList<>();
        boolean addingItems = true;
        double totalAmount = 0;

        while (addingItems) {
            System.out.println("\nAvailable products:");
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
                    System.out.println("Added: " + selectedProduct.getName() + " ($" + selectedProduct.getPrice() + ")");
                    System.out.println("Current total: $" + totalAmount);
                } else {
                    System.out.println("Product is out of stock!");
                }
            } else {
                System.out.println("Invalid product number!");
            }
        }

        if (selectedItems.isEmpty()) {
            System.out.println("Transaction cancelled - no items selected.");
            return;
        }

        // Применение скидки VIP клиента
        if (selectedCustomer.isVIP()) {
            double discount = selectedCustomer.getLoyaltyDiscount();
            double discountAmount = totalAmount * discount / 100;
            totalAmount -= discountAmount;
            System.out.printf("Applied VIP discount of %.0f%%: -$%.2f%n", discount, discountAmount);
        }

        // Создание транзакции
        Transaction transaction = new Transaction(
                selectedCustomer.getName() + " " + selectedCustomer.getSurname(),
                selectedItems,
                totalAmount,
                "Pending"
        );

        transactions.add(transaction);

        // Добавление баллов лояльности
        int pointsEarned = (int)(totalAmount / 100); // 1 балл за каждые 100 тг
        selectedCustomer.addLoyaltyPoints(pointsEarned);

        System.out.println("\n✓ Transaction created successfully!");
        System.out.println("Transaction ID: " + transaction.getTransactionId());
        System.out.printf("Total amount: $%.2f%n", totalAmount);
        System.out.println("Status: " + transaction.getStatus());
        System.out.println("Loyalty points earned: " + pointsEarned);
    }

    private static void completeTransaction() {
        viewAllTransactions();
        if (transactions.isEmpty()) return;

        int index = readInt("Select transaction number to complete: ") - 1;

        if (index < 0 || index >= transactions.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Transaction transaction = transactions.get(index);
        transaction.completeOrder();
        System.out.println("✓ Transaction completed!");
        System.out.println("New status: " + transaction.getStatus());
    }

    private static void cancelTransaction() {
        viewAllTransactions();
        if (transactions.isEmpty()) return;

        int index = readInt("Select transaction number to cancel: ") - 1;

        if (index < 0 || index >= transactions.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Transaction transaction = transactions.get(index);
        transaction.cancelOrder();
        System.out.println("✓ Transaction cancelled!");
        System.out.println("New status: " + transaction.getStatus());
    }

    private static void processTransaction() {
        viewAllTransactions();
        if (transactions.isEmpty()) return;

        int index = readInt("Select transaction number to process: ") - 1;

        if (index < 0 || index >= transactions.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Transaction transaction = transactions.get(index);
        transaction.startProcessing();
        System.out.println("✓ Transaction processing started!");
        System.out.println("New status: " + transaction.getStatus());
    }

    private static void applyTransactionDiscount() {
        viewAllTransactions();
        if (transactions.isEmpty()) return;

        int index = readInt("Select transaction number for discount: ") - 1;

        if (index < 0 || index >= transactions.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        double discount = readDouble("Enter discount percentage: ");
        Transaction transaction = transactions.get(index);

        System.out.printf("Amount before discount: $%.2f%n", transaction.getTotalAmount());
        transaction.applyDiscount(discount);
        System.out.printf("Amount after discount: $%.2f%n", transaction.getTotalAmount());
        System.out.println("✓ Discount applied!");
    }

    private static void viewTransactionReceipt() {
        viewAllTransactions();
        if (transactions.isEmpty()) return;

        int index = readInt("Select transaction number: ") - 1;

        if (index < 0 || index >= transactions.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Transaction transaction = transactions.get(index);
        System.out.println("\n=== TRANSACTION RECEIPT ===");
        transaction.printReceipt();
    }

    // === НОВЫЙ РАЗДЕЛ: Управление сотрудниками с полиморфизмом ===
    private static void manageStaff() {
        boolean back = false;

        while (!back) {
            System.out.println("\n=== STAFF MANAGEMENT (Polymorphism Demo) ===");
            System.out.println("1. View All Staff (Polymorphic List)");
            System.out.println("2. Add General Staff");
            System.out.println("3. Add Cashier");
            System.out.println("4. Add Store Manager");
            System.out.println("5. Add Stock Clerk");
            System.out.println("6. Make Staff Work (Polymorphism in Action)");
            System.out.println("7. Calculate Bonuses (Different for each type)");
            System.out.println("8. Show Staff Types (Using instanceof)");
            System.out.println("9. Access Child-Specific Methods (Using Casting)");
            System.out.println("0. Back to Main Menu");

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
                case 9: accessChildMethods(); break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void viewAllStaff() {
        System.out.println("\n=== ALL STAFF MEMBERS (Polymorphic List) ===");
        if (staffMembers.isEmpty()) {
            System.out.println("No staff members yet.");
        } else {
            for (int i = 0; i < staffMembers.size(); i++) {
                Staff staff = staffMembers.get(i);
                // Полиморфный вызов toString() - каждый тип покажет свою информацию
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
            System.out.println("✓ General staff added: " + staff);
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
            staffMembers.add(cashier); // Добавляем в общий список Staff
            System.out.println("✓ Cashier added: " + cashier);
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
            staffMembers.add(manager); // Добавляем в общий список Staff
            System.out.println("✓ Store Manager added: " + manager);
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
            staffMembers.add(clerk); // Добавляем в общий список Staff
            System.out.println("✓ Stock Clerk added: " + clerk);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void makeStaffWork() {
        System.out.println("\n=== MAKING STAFF WORK (Polymorphism Demo) ===");
        if (staffMembers.isEmpty()) {
            System.out.println("No staff members to work.");
            return;
        }

        System.out.println("Each staff member works differently:");
        System.out.println("-".repeat(50));

        // Полиморфный вызов - каждый тип выполнит свою версию work()
        for (Staff staff : staffMembers) {
            System.out.print(staff.getName() + " (" + staff.getPosition() + "): ");
            staff.work(); // Полиморфный вызов!
        }
    }

    private static void calculateStaffBonuses() {
        System.out.println("\n=== CALCULATING BONUSES (Different for each type) ===");
        if (staffMembers.isEmpty()) {
            System.out.println("No staff members.");
            return;
        }

        System.out.println("Bonuses are calculated differently for each staff type:");
        System.out.println("-".repeat(70));

        // Полиморфный вызов - каждый тип рассчитает бонус по-своему
        for (Staff staff : staffMembers) {
            double bonus = staff.calculateBonus(); // Полиморфный вызов!
            System.out.printf("%s: Bonus = $%.2f%n", staff.getName(), bonus);
        }
    }

    private static void showStaffTypes() {
        System.out.println("\n=== STAFF TYPES (Using instanceof) ===");
        if (staffMembers.isEmpty()) {
            System.out.println("No staff members.");
            return;
        }

        int generalCount = 0, cashierCount = 0, managerCount = 0, clerkCount = 0;

        // Использование instanceof для определения типов
        for (Staff staff : staffMembers) {
            if (staff instanceof Cashier) {
                cashierCount++;
                System.out.println("✓ " + staff.getName() + " is a [Cashier]");
            } else if (staff instanceof StoreManager) {
                managerCount++;
                System.out.println("✓ " + staff.getName() + " is a [Store Manager]");
            } else if (staff instanceof StockClerk) {
                clerkCount++;
                System.out.println("✓ " + staff.getName() + " is a [Stock Clerk]");
            } else {
                generalCount++;
                System.out.println("✓ " + staff.getName() + " is [General Staff]");
            }
        }

        System.out.println("\n=== TYPE SUMMARY ===");
        System.out.println("General Staff: " + generalCount);
        System.out.println("Cashiers: " + cashierCount);
        System.out.println("Store Managers: " + managerCount);
        System.out.println("Stock Clerks: " + clerkCount);
        System.out.println("Total: " + staffMembers.size());
    }

    private static void accessChildMethods() {
        System.out.println("\n=== ACCESSING CHILD-SPECIFIC METHODS (Using Casting) ===");
        if (staffMembers.isEmpty()) {
            System.out.println("No staff members.");
            return;
        }

        System.out.println("Demonstrating child-specific methods with casting:");
        System.out.println("-".repeat(60));

        for (Staff staff : staffMembers) {
            System.out.println("\nChecking: " + staff.getName());

            // Использование instanceof и кастинга
            if (staff instanceof Cashier) {
                Cashier cashier = (Cashier) staff; // Downcasting
                cashier.processPayment(150.75);
                System.out.println("   Transactions processed: " + cashier.getTransactionsProcessed());

            } else if (staff instanceof StoreManager) {
                StoreManager manager = (StoreManager) staff; // Downcasting
                manager.conductMeeting();
                manager.addDepartment();
                System.out.println("   Departments managed: " + manager.getDepartmentCount());

            } else if (staff instanceof StockClerk) {
                StockClerk clerk = (StockClerk) staff; // Downcasting
                clerk.stockShelves(3);
                clerk.checkExpiryDates();
                System.out.println("   Section: " + clerk.getAssignedSection());

            } else {
                System.out.println("   (General staff - no special methods)");
            }
        }
    }

    // === Системная сводка ===
    private static void viewSystemSummary() {
        System.out.println("\n=== SYSTEM SUMMARY ===");
        System.out.println("Products: " + products.size() + " items");
        System.out.println("Customers: " + customers.size() + " registered");
        System.out.println("Transactions: " + transactions.size() + " completed");
        System.out.println("Staff Members: " + staffMembers.size() + " employees");

        // Подсчёт типов сотрудников
        int cashiers = 0, managers = 0, clerks = 0, general = 0;
        for (Staff staff : staffMembers) {
            if (staff instanceof Cashier) cashiers++;
            else if (staff instanceof StoreManager) managers++;
            else if (staff instanceof StockClerk) clerks++;
            else general++;
        }

        System.out.println("  - Cashiers: " + cashiers);
        System.out.println("  - Store Managers: " + managers);
        System.out.println("  - Stock Clerks: " + clerks);
        System.out.println("  - General Staff: " + general);

        // VIP клиенты
        long vipCount = customers.stream().filter(Customer::isVIP).count();
        System.out.println("VIP Customers: " + vipCount);

        // Общая сумма транзакций
        double totalRevenue = transactions.stream()
                .mapToDouble(Transaction::getTotalAmount)
                .sum();
        System.out.printf("Total Revenue: $%.2f%n", totalRevenue);

        // Баллы лояльности
        int totalPoints = customers.stream()
                .mapToInt(Customer::getLoyaltyPoints)
                .sum();
        System.out.println("Total Loyalty Points: " + totalPoints);

        // Доступные продукты
        long availableProducts = products.stream()
                .filter(Product::isAvailable)
                .count();
        System.out.println("Available Products: " + availableProducts + "/" + products.size());
    }

    // === Демонстрация полиморфизма ===
    private static void demonstratePolymorphism() {
        System.out.println("\n=== POLYMORPHISM DEMONSTRATION ===");
        System.out.println("This demonstrates all polymorphism concepts:");
        System.out.println("=".repeat(60));

        // 1. Показываем список с разными типами
        System.out.println("\n1. ONE ArrayList<Staff> stores ALL object types:");
        viewAllStaff();

        // 2. Полиморфный вызов методов
        System.out.println("\n2. Polymorphic method calls (work()):");
        if (!staffMembers.isEmpty()) {
            for (Staff staff : staffMembers) {
                System.out.print("   ");
                staff.work(); // Разное поведение для разных типов
            }
        }

        // 3. Разное поведение для calculateBonus()
        System.out.println("\n3. Different behavior for calculateBonus():");
        if (!staffMembers.isEmpty()) {
            for (Staff staff : staffMembers) {
                double bonus = staff.calculateBonus();
                System.out.printf("   %s: $%.2f bonus%n", staff.getName(), bonus);
            }
        }

        // 4. Использование instanceof
        System.out.println("\n4. Using instanceof to identify types:");
        if (!staffMembers.isEmpty()) {
            for (Staff staff : staffMembers) {
                String type = "General Staff";
                if (staff instanceof Cashier) type = "Cashier";
                else if (staff instanceof StoreManager) type = "Store Manager";
                else if (staff instanceof StockClerk) type = "Stock Clerk";

                System.out.printf("   %s is a [%s]%n", staff.getName(), type);
            }
        }

        // 5. Использование кастинга
        System.out.println("\n5. Using casting for child-specific methods:");
        if (!staffMembers.isEmpty()) {
            for (Staff staff : staffMembers) {
                System.out.print("   " + staff.getName() + ": ");

                if (staff instanceof Cashier) {
                    ((Cashier) staff).processPayment(99.99); // Casting
                } else if (staff instanceof StoreManager) {
                    ((StoreManager) staff).conductMeeting(); // Casting
                } else if (staff instanceof StockClerk) {
                    ((StockClerk) staff).stockShelves(2); // Casting
                } else {
                    System.out.print("No special methods");
                }
                System.out.println();
            }
        }

        System.out.println("\n✓ All polymorphism concepts demonstrated!");
    }

    // === Ваш оригинальный демо-код ===
    private static void runOriginalDemo() {
        System.out.println("\n=== RUNNING ORIGINAL DEMO CODE ===");
        System.out.println("This runs your original demonstration of Product, Customer, and Transaction classes");
        System.out.println("-".repeat(60));

        // Здесь будет ваш оригинальный код
        System.out.println("To save space, this is a placeholder for your original demo.");
        System.out.println("You can copy your original main() method code here.");
        System.out.println("For now, showing a summary of the original functionality:");

        System.out.println("\nOriginal code demonstrates:");
        System.out.println("✓ 15 Product objects creation");
        System.out.println("✓ 5 Transaction objects creation");
        System.out.println("✓ 3 Customer objects (using different constructors)");
        System.out.println("✓ Testing all getters and setters");
        System.out.println("✓ Testing additional methods like applyDiscount, addLoyaltyPoints, etc.");

        // Можно добавить вызов отдельного метода с полным демо
        System.out.println("\nTo see the full original demo, check your previous Main.java file.");
    }

    // === Вспомогательные методы ===
    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number!");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        return value;
    }

    private static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a valid number!");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // Очистка буфера
        return value;
    }

    private static void pause() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
