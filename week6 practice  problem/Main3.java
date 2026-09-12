import java.util.Arrays;

class EventTicket {

    protected double basePrice;
    protected double paidAmount;

    // Private array
    private double[] lateFeeHistory;

    private int feeCount;

    public EventTicket(double basePrice) {

        this.basePrice = basePrice;
        this.paidAmount = 0;

        lateFeeHistory = new double[10];
        feeCount = 0;
    }


    public void pay(double amount) {
        paidAmount += amount;
    }


    public double getBalanceDue() {
        return basePrice - paidAmount;
    }


    // Parent method
    protected void applyLateFee(double amount) {

        if (feeCount < 10) {

            lateFeeHistory[feeCount] = amount;
            feeCount++;
        }
    }


    // Defensive copy
    public double[] getLateFeeHistory() {

        return Arrays.copyOf(
            lateFeeHistory,
            feeCount
        );
    }
}


class WorkshopTicket extends EventTicket {

    public WorkshopTicket(double basePrice) {
        super(basePrice);
    }


    // Method overriding
    @Override
    protected void applyLateFee(double amount) {

        // Workshop penalty is DOUBLE
        super.applyLateFee(amount * 2);
    }
}


public class Main3 {

    public static void main(String[] args) {

        WorkshopTicket w =
            new WorkshopTicket(1200);

        w.pay(1200);

        // Original amount = 100
        w.applyLateFee(100);

        System.out.println(
            w.getBalanceDue()
        );


        // Get history
        double[] history =
            w.getLateFeeHistory();

        System.out.println(
            Arrays.toString(history)
        );


        // Try modifying returned array
        history[0] = 999;

        // Original internal array is safe
        System.out.println(
            Arrays.toString(
                w.getLateFeeHistory()
            )
        );
    }
}