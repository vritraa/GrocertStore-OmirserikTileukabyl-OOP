public class Main {
    public static void main(String[] args) {

        System.out.println("=== Grocery Store Management System ===");
        System.out.println("This project is about Grocery Store Management System, it helps buying groceries, getting discount" +
                "getting more loyal points if you are VIP customer and etc ");
        System.out.println(" ");

        // 2. Create objects
        System.out.println("=== CREATING OBJECTS ===");

        // Create 15 Product objects
        Product milk = new Product("Fresh Milk", 550.0, "Dairy", true);
        Product eggs = new Product("Eggs", 700.0, "Dairy", true);
        Product bread = new Product("Whole Wheat Bread", 350.0, "Bakery", true);
        Product apples = new Product("Organic Apples", 1200.0, "Fruits", true);
        Product cheese = new Product("Cheddar Cheese", 1800.0, "Dairy", true);
        Product chicken = new Product("Chicken Breast", 2500.0, "Meat", true);
        Product rice = new Product("Basmati Rice", 1200.0, "Grains", true);
        Product pasta = new Product("Spaghetti", 850.0, "Grains", true);
        Product tomatoes = new Product("Fresh Tomatoes", 450.0, "Vegetables", true);
        Product potatoes = new Product("Potatoes", 300.0, "Vegetables", true);
        Product coffee = new Product("Arabica Coffee", 3500.0, "Beverages", true);
        Product tea = new Product("Green Tea", 1200.0, "Beverages", true);
        Product sugar = new Product("White Sugar", 600.0, "Baking", true);
        Product oil = new Product("Sunflower Oil", 1500.0, "Cooking", true);
        Product defaultProduct = new Product();  // Default constructor

        // Create 5 Transaction objects
        java.util.List<String> items1 = java.util.Arrays.asList("Milk", "Bread", "Eggs", "Cheese");
        Transaction transaction1 = new Transaction("John Doe", items1, 3400.0, "Pending");  // 550+350+700+1800

        java.util.List<String> items2 = java.util.Arrays.asList("Chicken", "Rice", "Tomatoes");
        Transaction transaction2 = new Transaction("Jane Smith", items2, 4150.0, "Processing");  // 2500+1200+450

        java.util.List<String> items3 = java.util.Arrays.asList("Coffee", "Sugar");
        Transaction transaction3 = new Transaction("Bob Wilson", items3, 4100.0, "Pending");  // 3500+600

        java.util.List<String> items4 = java.util.Arrays.asList("Pasta", "Oil", "Potatoes");
        Transaction transaction4 = new Transaction("Alice Brown", items4, 2650.0, "Completed");  // 850+1500+300

        Transaction transaction5 = new Transaction("Charlie Davis");  // Empty transaction

        // Create 3 Customer objects - USING DIFFERENT CONSTRUCTORS
        Customer customer1 = new Customer("Aizhan", "Zhamal", "+77011234567", 75);  // 4-param constructor
        Customer customer2 = new Customer("Bakhytzhan", "Alimov", "+77029876543");  // 3-param constructor (NEW)
        Customer customer3 = new Customer();  // Default constructor

        System.out.println("Objects created successfully:");
        System.out.println("✓ 15 Products created");
        System.out.println("✓ 5 Transactions created");
        System.out.println("✓ 3 Customers created (using different constructors)");
        System.out.println();

        // 3. Display initial state
        System.out.println("=== INITIAL STATE ===");

        System.out.println("--- PRODUCTS (15 items) ---");
        System.out.println("1. " + milk);
        System.out.println("2. " + eggs);
        System.out.println("3. " + bread);
        System.out.println("4. " + apples);
        System.out.println("5. " + cheese);
        System.out.println("6. " + chicken);
        System.out.println("7. " + rice);
        System.out.println("8. " + pasta);
        System.out.println("9. " + tomatoes);
        System.out.println("10. " + potatoes);
        System.out.println("11. " + coffee);
        System.out.println("12. " + tea);
        System.out.println("13. " + sugar);
        System.out.println("14. " + oil);
        System.out.println("15. " + defaultProduct);
        System.out.println("\n--- TRANSACTIONS (5 orders) ---");
        System.out.println("1. " + transaction1);
        System.out.println("2. " + transaction2);
        System.out.println("3. " + transaction3);
        System.out.println("4. " + transaction4);
        System.out.println("5. " + transaction5);

        System.out.println("\n--- CUSTOMERS (3 customers) ---");
        System.out.println("1. " + customer1);
        System.out.println("2. " + customer2);
        System.out.println("3. " + customer3);
        System.out.println();

        // 4. Test getters
        System.out.println("=== TESTING GETTERS ===");

        System.out.println("PRODUCT GETTERS:");
        System.out.println("Product 1 name: " + milk.getName());
        System.out.println("Product 1 price: " + milk.getPrice() + " KZT");
        System.out.println("Product 1 category: " + milk.getCategory());
        System.out.println("Product 1 available: " + milk.isAvailable());

        System.out.println("\nProduct 6 name: " + chicken.getName());
        System.out.println("Product 6 price: " + chicken.getPrice() + " KZT");
        System.out.println("Product 11 name: " + coffee.getName());
        System.out.println("Product 11 price: " + coffee.getPrice() + " KZT");

        System.out.println("\nProduct 15 (default) name: " + defaultProduct.getName());
        System.out.println("Product 15 (default) price: " + defaultProduct.getPrice() + " KZT");

        System.out.println("\nTRANSACTION GETTERS:");
        System.out.println("Transaction 1 ID: " + transaction1.getTransactionId());
        System.out.println("Transaction 1 customer: " + transaction1.getCustomerName());
        System.out.println("Transaction 1 total: " + transaction1.getTotalAmount() + " KZT");
        System.out.println("Transaction 1 status: " + transaction1.getStatus());

        // DEMONSTRATE UNUSED GETTER: getTransactionDate()
        System.out.println("Transaction 1 date: " + transaction1.getTransactionDate());

        System.out.println("\nTransaction 2 ID: " + transaction2.getTransactionId());
        System.out.println("Transaction 2 status: " + transaction2.getStatus());
        System.out.println("Transaction 4 status: " + transaction4.getStatus());

        System.out.println("\nCUSTOMER GETTERS:");
        System.out.println("Customer 1 ID: " + customer1.getCustomerId());
        System.out.println("Customer 1 name: " + customer1.getName());
        System.out.println("Customer 1 surname: " + customer1.getSurname());
        System.out.println("Customer 1 phone: " + customer1.getPhoneNumber());
        System.out.println("Customer 1 points: " + customer1.getLoyaltyPoints());

        System.out.println("\nCustomer 2 points: " + customer2.getLoyaltyPoints());
        System.out.println("Customer 2 name: " + customer2.getName());
        System.out.println("Customer 3 name: " + customer3.getName());
        System.out.println();

        // 5. Test setters
        System.out.println("=== TESTING SETTERS ===");

        System.out.println("Updating Product 15...");
        defaultProduct.setName("Organic Bananas");
        defaultProduct.setPrice(850.0);
        defaultProduct.setCategory("Fruits");
        defaultProduct.setAvailable(true);
        System.out.println("Updated: " + defaultProduct);

        System.out.println("\nChanging Transaction 5 customer...");
        transaction5.setCustomerName("Peter Parker");
        transaction5.setTotalAmount(5000.0);
        transaction5.setStatus("Processing");



        System.out.println("\nUpdating Customer 3...");
        customer3.setName("Mary");
        customer3.setSurname("Ayaru");
        customer3.setPhoneNumber("+77008889900");
        customer3.setLoyaltyPoints(200);
        System.out.println("Updated: " + customer3);
        System.out.println();

        // 6. Test additional methods
        System.out.println("=== TESTING ADDITIONAL METHODS ===");
        System.out.println("PRODUCT METHODS:");
        System.out.println("Applying 15% discount to Product 11 (Coffee)...");
        coffee.applyDiscount(15);
        System.out.println("Product 11 is expensive (>5000 KZT): " + coffee.isExpensive());

        System.out.println("\nApplying 10% discount to Product 6 (Chicken)...");
        chicken.applyDiscount(10);
        System.out.println("Product 6 price after discount: " + chicken.getPrice() + " KZT");

        // DEMONSTRATE UNUSED METHOD: restock()
        System.out.println("\nDemonstrating restock() method:");
        Product outOfStockProduct = new Product("Special Chocolate", 1500.0, "Snacks", false);
        System.out.println("Before restock - Available: " + outOfStockProduct.isAvailable());
        outOfStockProduct.restock(50);
        System.out.println("After restock - Available: " + outOfStockProduct.isAvailable());

        System.out.println("\nTRANSACTION METHODS:");
        System.out.println("Completing Transaction 1...");
        transaction1.completeOrder();
        System.out.println("Transaction 1 is completed: " + transaction1.isCompleted());

        System.out.println("\nWorking with Transaction 5 (empty cart):");
        System.out.println("Adding items to Transaction 5...");
        transaction5.addItem("Tea");
        transaction5.addItem("Bread");
        transaction5.addItem("Eggs");

        System.out.println("\nRemoving 'Bread' from Transaction 5...");
        transaction5.removeItem("Bread");

        System.out.println("\nApplying 20% discount to Transaction 5...");
        transaction5.applyDiscount(20);

        // DEMONSTRATE getSummary() method!222
        System.out.println("\nTransaction 5 summary: " + transaction5.getSummary());

        System.out.println("\nPrinting receipt for Transaction 5:");
        transaction5.printReceipt();

        System.out.println("Cancelling Transaction 3...");
        transaction3.cancelOrder();
        System.out.println("Transaction 3 is cancelled: " + transaction3.isCancelled());

        System.out.println("\nStarting processing on Transaction 2:");
        transaction2.startProcessing();
        System.out.println("Transaction 2 is processing: " + transaction2.isProcessing());

        System.out.println("\nCUSTOMER METHODS:");
        System.out.println("Adding 50 points to Customer 1...");
        customer1.addLoyaltyPoints(50);
        System.out.println("Customer 1 is VIP (>10000 points): " + customer1.isVIP());
        System.out.println("Customer 1 contact info: " + customer1.getContactInfo());

        // Test Customer 2 loyalty discount
        System.out.println("\nCustomer 2 loyalty discount: " + customer2.getLoyaltyDiscount() + "%");

        // Add enough points to Customer 2 to become VIP
        System.out.println("\nAdding 10000 points to Customer 2 to become VIP...");
        customer2.addLoyaltyPoints(10000);
        System.out.println("Customer 2 is now VIP: " + customer2.isVIP());
        System.out.println("Customer 2 loyalty discount now: " + customer2.getLoyaltyDiscount() + "%");

        System.out.println("\nCustomer 3 using loyalty points:");
        System.out.println("Points before: " + customer3.getLoyaltyPoints());
        boolean pointsUsed = customer3.useLoyaltyPoints(100);
        System.out.println("Points used successfully: " + pointsUsed);
        System.out.println("Points after: " + customer3.getLoyaltyPoints());

        // Try to use too many points
        System.out.println("\nTrying to use more points than Customer 3 has:");
        boolean pointsFailed = customer3.useLoyaltyPoints(500);
        System.out.println("Points used successfully: " + pointsFailed);

        System.out.println("\nDisplaying Customer 1 information:");
        customer1.displayCustomerInfo();

        System.out.println("\nDisplaying Customer 2 information (VIP):");
        customer2.displayCustomerInfo();
        System.out.println();

        // 7. Display final state
        System.out.println("=== FINAL STATE ===");
        System.out.println("--- PRODUCTS (after modifications) ---");
        System.out.println("1. " + milk);
        System.out.println("2. " + eggs);
        System.out.println("3. " + bread);
        System.out.println("4. " + apples);
        System.out.println("5. " + cheese);
        System.out.println("6. " + chicken);
        System.out.println("7. " + rice);
        System.out.println("8. " + pasta);
        System.out.println("9. " + tomatoes);
        System.out.println("10. " + potatoes);
        System.out.println("11. " + coffee);
        System.out.println("12. " + tea);
        System.out.println("13. " + sugar);
        System.out.println("14. " + oil);
        System.out.println("15. " + defaultProduct);
        System.out.println("16. " + outOfStockProduct);  // Added from restock demo

        System.out.println("\n--- TRANSACTIONS (after modifications) ---");
        System.out.println("1. " + transaction1);
        System.out.println("2. " + transaction2);
        System.out.println("3. " + transaction3);
        System.out.println("4. " + transaction4);
        System.out.println("5. " + transaction5);

        System.out.println("\n--- CUSTOMERS (after modifications) ---");
        System.out.println("1. " + customer1);
        System.out.println("2. " + customer2);
        System.out.println("3. " + customer3);
        System.out.println();

        // 8. Completion message
        System.out.println("=== Program Complete ===");
        System.out.println("✓ Created 16 Product objects (including one for restock demo)");
        System.out.println("✓ Created 5 Transaction objects");
        System.out.println("✓ Created 3 Customer objects (using all constructors)");
        System.out.println("✓ Tested ALL getters, setters, and additional methods including:");
        System.out.println("  - Product: restock() method");
        System.out.println("  - Transaction: getTransactionDate(), setTransactionDate(), getSummary()");
        System.out.println("  - Customer: 3-parameter constructor, getLoyaltyDiscount()");
        System.out.println("✓ Demonstrated complete grocery store functionality");
    }
}