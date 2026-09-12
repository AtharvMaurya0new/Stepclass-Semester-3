class EventTicket {
    protected String attendeeId;
    protected double basePrice;
    protected double paidAmount;

    // Constructor
    public EventTicket(String attendeeId, double basePrice) {

        // Validation
        if (attendeeId == null ||
            attendeeId.trim().isEmpty() ||
            attendeeId.trim().length() < 4) {

            throw new IllegalArgumentException("Invalid attendee ID");
        }

        this.attendeeId = attendeeId;
        this.basePrice = basePrice;
        this.paidAmount = 0;
    }

    // Payment method
    public void pay(double amount) {
        paidAmount += amount;
    }

    // Remaining balance
    public double getBalanceDue() {
        return basePrice - paidAmount;
    }

    // Batch registration
    public static String registerBatch(String[] attendeeIds, double basePrice) {

        int registered = 0;
        int rejected = 0;

        for (String id : attendeeIds) {

            try {
                EventTicket ticket = new EventTicket(id, basePrice);
                registered++;
            }
            catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Registered: " + registered + " | Rejected: " + rejected;
    }
}


class WorkshopTicket extends EventTicket {

    private String track;

    public WorkshopTicket(String attendeeId, double basePrice, String track) {

        // Calling parent constructor
        super(attendeeId, basePrice);

        this.track = track;
    }
}


public class Main {
    public static void main(String[] args) {

        // Example 1
        try {
            EventTicket t = new EventTicket("ST1", 500);
        }
        catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }


        // Example 2
        WorkshopTicket w =
            new WorkshopTicket("STU2", 1200, "AI/ML");

        w.pay(500);

        System.out.println(w.getBalanceDue());


        // Example 3
        String[] ids = {
            "STU1",
            "ST1",
            "STU2",
            " ",
            "STU3"
        };

        System.out.println(
            EventTicket.registerBatch(ids, 500)
        );
    }
}