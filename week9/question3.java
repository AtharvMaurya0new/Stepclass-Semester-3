
import java.util.*;

public class question3 {

    static long countPeriods(int[] arr, long k) {

        HashMap<Long, Integer> map = new HashMap<>();

        long sum = 0;
        long count = 0;

        map.put(0L, 1);

        for (int i = 0; i < arr.length; i++) {

            sum = sum + arr[i];

            if (map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
            }

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] a = {3, 4, -7, 1, 3, 3, 1, -4};

        System.out.println(countPeriods(a, 7));

        int[] b = {1, 2, 3};

        System.out.println(countPeriods(b, 10));
    }
}
