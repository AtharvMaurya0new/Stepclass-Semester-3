class FoodOrder {

    String studentName;
    String dishName;
    boolean delivered;

    // Parameterized constructor
    FoodOrder(String studentName, String dishName) {

        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid student name");
        }

        if (dishName == null || dishName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid dish name");
        }

        this.studentName = studentName;
        this.dishName = dishName;
        this.delivered = false;
    }

    void markDelivered() {

        if (!delivered) {
            delivered = true;
            System.out.println("Order delivered for " + studentName);
        } else {
            System.out.println("Order already delivered for " + studentName);
        }
    }

    static void processBatch(String[][] rawOrders) {

        int valid = 0;
        int rejected = 0;

        for (int i = 0; i < rawOrders.length; i++) {

            try {
                FoodOrder order =
                    new FoodOrder(rawOrders[i][0], rawOrders[i][1]);

                valid++;

            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        System.out.println("Valid: " + valid + " | Rejected: " + rejected);
    }

    public static void main(String[] args) {

        String[][] rawOrders = {
            {"Ravi", "Paneer Butter Masala"},
            {"", "Chole Bhature"},
            {"Meera", ""},
            {"", "Veg Biryani"}
        };

        processBatch(rawOrders);
    }
}