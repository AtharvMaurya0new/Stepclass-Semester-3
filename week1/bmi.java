import java.util.*;

class bmi {

    static double getBmiStatus(double bmi) {
        return bmi;
    }

    static String getStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person\tHeight(m)\tWeight(kg)\tBMI\tStatus");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);

            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t%s%n",
                    i + 1, heights[i], weights[i], bmi, getStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 10;

        double[] heights = new double[n];
        double[] weights = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter height of Person " + (i + 1) + " (m): ");
            heights[i] = sc.nextDouble();

            System.out.print("Enter weight of Person " + (i + 1) + " (kg): ");
            weights[i] = sc.nextDouble();
        }

        System.out.println("\n--- Wellness Report ---");
        printWellnessReport(heights, weights);

        sc.close();
    }
}