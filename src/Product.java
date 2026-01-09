public class Product {

    private String name;
    private double price;
    private String category;
    private boolean isAvailable;

    public Product(String name, double price, String category, boolean isAvailable) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public Product() {
        this.name = "Unknown Product";
        this.price = 0.0;
        this.category = "Uncategorized";
        this.isAvailable = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public void applyDiscount(double percentage) {
        if (percentage >= 0 && percentage <= 100) {
            double discountMultiplier = 1 - (percentage / 100);
            this.price = this.price * discountMultiplier;
            System.out.println(
                    "Applied " + percentage + "% discount to " + name +
                            ". New price: " + this.price + " KZT"
            );
        } else {
            System.out.println("Invalid discount percentage. Please enter a value between 0 and 100.");
        }
    }

    public boolean isExpensive() {
        return this.price > 5000;
    }

    public void displayProductInfo() {
        System.out.println("\n=== Product Information ===");
        System.out.println("Name: " + this.name);
        System.out.println("Price: " + String.format("%.2f", this.price) + " KZT");
        System.out.println("Category: " + this.category);
        System.out.println("Available: " + (this.isAvailable ? "Yes" : "No"));
        System.out.println("Expensive (>5000 KZT): " + (this.isExpensive() ? "Yes" : "No"));
    }

    public void restock(int quantity) {
        this.isAvailable = true;
        System.out.println(
                "Restocked " + quantity + " units of " + this.name +
                        ". Product is now available."
        );
    }

    @Override
    public String toString() {
        return String.format(
                "Product[name='%s', price=%.2f KZT, category='%s', available=%s]",
                name, price, category, isAvailable ? "Yes" : "No"
        );
    }
}
