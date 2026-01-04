public class Customer {
    private int customerId;
    private String name;
    private String surname;
    private String phoneNumber;
    private int loyaltyPoints;
    private static int customerCounter = 1000;

    public Customer(String name, String surname, String phoneNumber, int loyaltyPoints) {
        this.customerId = ++customerCounter;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.loyaltyPoints = loyaltyPoints;
    }

    public Customer(String name, String surname, String phoneNumber) {
        this(name,surname, phoneNumber, 0);
    }


    public Customer() {
        this("Unknown","Unknown2", "+77000000000", 0);
    }



    public int getCustomerId() {
        return customerId;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.length() >= 10) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Invalid phone number. Must be at least 10 digits.");
        }
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            System.out.println("Loyalty points cannot be negative!");
        }
    }

    public void addLoyaltyPoints(int points) {
        if (points > 0) {
            this.loyaltyPoints += points;
            System.out.println("Added " + points + " loyalty points to " + this.name +
                    ". Total points: " + this.loyaltyPoints);
            if (this.loyaltyPoints >= 10000 && this.loyaltyPoints - points < 10000) {
                System.out.println("🎉 Congratulations! " + this.name + " is now a VIP customer!");
            }
        } else {
            System.out.println("Cannot add negative or zero points!");
        }
    }

    public boolean useLoyaltyPoints(int points) {
        if (points <= 0) {
            System.out.println("You should have at least 1 loyalty point!");
            return false;
        }

        if (this.loyaltyPoints >= points) {
            this.loyaltyPoints -= points;
            System.out.println("Used " + points + " loyalty points for " + this.name +
                    ". Remaining points: " + this.loyaltyPoints);
            return true;
        } else {
            System.out.println("Insufficient points! " + this.name +
                    " has only " + this.loyaltyPoints + " points, but needs " + points);
            return false;
        }
    }

    public boolean isVIP() {
        return this.loyaltyPoints > 10000;
    }

    public String getContactInfo() {
        return this.name + " " + this.surname + " | Phone: " + this.phoneNumber;
    }





    public double getLoyaltyDiscount() {
        if (isVIP()) {
            return 10.0;
        } else if (loyaltyPoints >= 5000) {
            return 5.0;
        } else {
            return 0.0;
        }
    }

    public void displayCustomerInfo() {
        System.out.println("\n=== CUSTOMER INFORMATION ===");
        System.out.println("ID: " + this.customerId);
        System.out.println("Name: " + this.name);
        System.out.println("Phone: " + this.phoneNumber);
        System.out.println("Loyalty Points: " + this.loyaltyPoints);
        System.out.println("VIP Status: " + (isVIP() ? "YES 🏆" : "No"));
        System.out.println("Contact Info: " + getContactInfo());
        System.out.println("Eligible Discount: " + getLoyaltyDiscount() + "%");
    }
    @Override
    public String toString() {
        String vipStatus = isVIP() ? "VIP" : "Regular";
        return String.format("Customer[ID=%d, Name='%s', Phone='%s', Points=%d, Status=%s]",
                customerId, name, phoneNumber, loyaltyPoints, vipStatus);
    }


}