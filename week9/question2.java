import java.util.*;

public class question2 {

    static int[] longestStreak(int[] costs, long budget) {
        int left = 0;
        long sum = 0;
        int maxLen = 0;
        int bestStart = -1;

        for (int right = 0; right < costs.length; right++) {
            sum += costs[right];

            while (sum > budget && left <= right) {
                sum -= costs[left];
                left++;
            }

            int currentLen = right - left + 1;
            if (currentLen > maxLen) {
                maxLen = currentLen;
                bestStart = left;
            }
        }

        return new int[]{maxLen, bestStart};
    }

    public static void main(String[] args) {
        int[] costs1 = {4, 2, 1, 7, 3, 1, 2, 1, 5};
        System.out.println(Arrays.toString(longestStreak(costs1, 8)));

        int[] costs2 = {9, 10};
        System.out.println(Arrays.toString(longestStreak(costs2, 8)));
    }
}