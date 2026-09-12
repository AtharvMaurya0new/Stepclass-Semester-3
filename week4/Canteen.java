import java.util.Arrays;

class Canteen implements Comparable<Canteen> {

    String canteenCode;
    String canteenName;
    int trustScore;

    // Main constructor
    Canteen(String canteenCode, String canteenName, int trustScore) {

        this.canteenCode = canteenCode;
        this.canteenName = canteenName;
        this.trustScore = trustScore;
    }

    // Constructor with default score = 3
    Canteen(String canteenCode, String canteenName) {

        this(canteenCode, canteenName, 3);
    }

    // Comparison for ranking
    public int compareTo(Canteen other) {

        // Higher trust score first
        if (this.trustScore != other.trustScore) {
            return other.trustScore - this.trustScore;
        }

        // Code in ascending order
        int codeCompare =
            this.canteenCode.compareTo(other.canteenCode);

        if (codeCompare != 0) {
            return codeCompare;
        }

        // Shorter name first
        return this.canteenName.length() - other.canteenName.length();
    }

    static Canteen[] rankCanteens(Canteen[] canteens) {

        Arrays.sort(canteens);

        return canteens;
    }

    public static void main(String[] args) {

        Canteen[] canteens = {
            new Canteen("HB3-C", "Spice Junction", 3),
            new Canteen("HB1-C", "Grand Mess", 5),
            new Canteen("HB2-C", "Southern Treats")
        };

        Canteen[] result = rankCanteens(canteens);

        for (Canteen c : result) {
            System.out.println(
                c.canteenCode + " - " +
                c.canteenName + " - " +
                c.trustScore
            );
        }
    }
}