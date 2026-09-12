final class SurgeFeeCalculator {

    private final double minimumSurgePercent;

    public SurgeFeeCalculator(double minimumSurgePercent) {
        this.minimumSurgePercent = minimumSurgePercent;
    }

    final double calculateSurgeFee(double orderValue, int delayMinutes) {

        if (orderValue < 0) {
            throw new IllegalArgumentException("Invalid order value");
        }

        if (delayMinutes < 0) {
            throw new IllegalArgumentException("Invalid delay minutes");
        }

        if (delayMinutes == 0) {
            return 0.0;
        }

        double surgePercent = 0.0;

        // First 5 minutes -> 0.5% per minute
        int firstBracket = Math.min(delayMinutes, 5);
        surgePercent += firstBracket * 0.5;

        // Minutes 6 to 15 -> 1% per minute
        if (delayMinutes > 5) {

            int secondBracket =
                Math.min(delayMinutes - 5, 10);

            surgePercent += secondBracket * 1.0;
        }

        // Minute 16 onwards -> 2% per minute
        if (delayMinutes > 15) {

            int thirdBracket = delayMinutes - 15;

            surgePercent += thirdBracket * 2.0;
        }

        // Minimum surge percentage floor
        surgePercent =
            Math.max(surgePercent, minimumSurgePercent);

        return orderValue * surgePercent / 100.0;
    }

    public static void main(String[] args) {

        SurgeFeeCalculator calculator =
            new SurgeFeeCalculator(1.0);

        System.out.println(
            "Rs " + calculator.calculateSurgeFee(500, 0)
        );

        System.out.println(
            "Rs " + calculator.calculateSurgeFee(500, 1)
        );

        System.out.println(
            "Rs " + calculator.calculateSurgeFee(500, 16)
        );
    }
}