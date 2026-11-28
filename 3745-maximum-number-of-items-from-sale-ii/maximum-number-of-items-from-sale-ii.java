import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // Step 1: Find maximum factor and minimum price
        int maxFactor = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

        // Step 2: Count frequency of each factor
        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Step 3: Calculate number of multiples
        for (int i = 1; i <= maxFactor; i++) {

            for (int j = i * 2; j <= maxFactor; j += i) {
                freq[i] += freq[j];
            }
        }

        // Step 4: Sort items by price
        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long remaining = budget;
        long answer = 0;

        // Step 5: Greedily purchase bonus-generating copies
        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            // No benefit compared with buying cheapest items
            if (price > 2L * minPrice) {
                break;
            }

            int gain = freq[factor] - 1;

            if (gain <= 0) {
                continue;
            }

            long take = Math.min(gain, remaining / price);

            answer += take * 2;
            remaining -= take * price;
        }

        // Step 6: Spend remaining budget on cheapest items
        answer += remaining / minPrice;

        return (int) answer;
    }
}