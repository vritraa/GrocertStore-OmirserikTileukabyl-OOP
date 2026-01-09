import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String transactionId;
    private String customerName;
    private List<String> items;
    private double totalAmount;
    private String status;
    private LocalDateTime transactionDate;

    private static int transactionCounter = 2000;

    public Transaction(String customerName, List<String> items, double totalAmount, String status) {
        this.transactionId = "TRX-" + transactionCounter++;
        this.customerName = customerName;
        this.items = new ArrayList<>(items);
        this.totalAmount = totalAmount;
        this.status = status;
        this.transactionDate = LocalDateTime.now();
    }

    public Transaction(String customerName, List<String> items) {
        this(customerName, items, calculateTotalAmount(items), "Pending");
    }

    public Transaction(String customerName) {
        this(customerName, new ArrayList<>(), 0.0, "Pending");
    }

    private static double calculateTotalAmount(List<String> items) {
        return items.size() * 0.0;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    public void setItems(List<String> items) {
        this.items = new ArrayList<>(items);
        this.totalAmount = calculateTotalAmount(items);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void completeOrder() {
        if (this.status.equals("Cancelled")) {
            System.out.println("Cannot complete a cancelled order!");
            return;
        }
        this.status = "Completed";
        System.out.println("Transaction " + transactionId + " has been completed.");
    }

    public void cancelOrder() {
        if (this.status.equals("Completed")) {
            System.out.println("Cannot cancel a completed order!");
            return;
        }
        this.status = "Cancelled";
        System.out.println("Transaction " + transactionId + " has been cancelled.");
    }

    public boolean isPending() {
        return this.status.equals("Pending");
    }

    public boolean isProcessing() {
        return this.status.equals("Processing");
    }

    public boolean isCompleted() {
        return this.status.equals("Completed");
    }

    public boolean isCancelled() {
        return this.status.equals("Cancelled");
    }

    public void startProcessing() {
        if (this.status.equals("Pending")) {
            this.status = "Processing";
            System.out.println("Transaction " + transactionId + " is now being processed.");
        } else {
            System.out.println("Cannot process order with status: " + this.status);
        }
    }

    public void addItem(String itemName) {
        if (this.status.equals("Completed") || this.status.equals("Cancelled")) {
            System.out.println("Cannot add items to a " + this.status.toLowerCase() + " transaction!");
            return;
        }
        this.items.add(itemName);
        this.totalAmount += 1000;
        System.out.println("Added " + itemName + " to transaction " + transactionId);
    }

    public void removeItem(String itemName) {
        if (this.status.equals("Completed") || this.status.equals("Cancelled")) {
            System.out.println("Cannot remove items from a " + this.status.toLowerCase() + " transaction!");
            return;
        }
        if (this.items.remove(itemName)) {
            this.totalAmount -= 1000;
            System.out.println("Removed " + itemName + " from transaction " + transactionId);
        } else {
            System.out.println("Item " + itemName + " not found in transaction!");
        }
    }

    public void applyDiscount(double percentage) {
        if (percentage >= 0 && percentage <= 100) {
            double discount = this.totalAmount * (percentage / 100);
            this.totalAmount -= discount;
            System.out.println("Applied " + percentage + "% discount to transaction " + transactionId);
            System.out.println("Discount amount: " + discount + " KZT");
            System.out.println("New total: " + this.totalAmount + " KZT");
        } else {
            System.out.println("Invalid discount percentage!");
        }
    }

    public void printReceipt() {
        System.out.println("\n========== GROCERY STORE RECEIPT ==========");
        System.out.println("Transaction ID: " + this.transactionId);
        System.out.println("Customer: " + this.customerName);
        System.out.println("Date: " + this.transactionDate.format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("Status: " + this.status);
        System.out.println("\nItems Purchased:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + items.get(i));
        }
        System.out.println("\nSubtotal: " + String.format("%.2f", this.totalAmount) + " KZT");
        System.out.println("Total: KZT");
        System.out.println("===========================================\n");
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format(
                "Transaction[ID=%s, Customer='%s', Items=%d, Total=%.2f KZT, Status='%s', Date=%s]",
                transactionId, customerName, items.size(), totalAmount, status,
                transactionDate.format(formatter)
        );
    }

    public String getSummary() {
        return transactionId + " - " + customerName + " - " + totalAmount + " KZT - " + status;
    }
}
