public class DeliverySlot {

    String orderId;
    String timeSlot;

    // Constructor 1
    DeliverySlot(String orderId, String timeSlot) {

        this.orderId = orderId;
        this.timeSlot = timeSlot;
    }

    // Constructor 2 - constructor chaining
    DeliverySlot(String orderId) {

        this(orderId, "ASAP");
    }

    boolean isPeakHour() {

        if (timeSlot.equals("12:00-13:00") ||
            timeSlot.equals("13:00-14:00") ||
            timeSlot.equals("19:00-20:00") ||
            timeSlot.equals("20:00-21:00")) {

            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        DeliverySlot d1 =
            new DeliverySlot("ORD101", "13:00-14:00");

        DeliverySlot d2 =
            new DeliverySlot("ORD102");

        System.out.println(d1.isPeakHour());
        System.out.println(d2.isPeakHour());
    }
}
