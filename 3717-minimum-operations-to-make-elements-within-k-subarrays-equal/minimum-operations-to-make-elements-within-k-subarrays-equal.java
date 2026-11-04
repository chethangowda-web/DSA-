import java.util.*;

class Solution {

    class DualHeap {
        TreeMap<Integer, Integer> lower = new TreeMap<>();
        TreeMap<Integer, Integer> upper = new TreeMap<>();

        int lowerSize = 0, upperSize = 0;
        long lowerSum = 0, upperSum = 0;

        void add(int num) {
            if (lower.isEmpty() || num <= lower.lastKey()) {
                lower.merge(num, 1, Integer::sum);
                lowerSize++;
                lowerSum += num;
            } else {
                upper.merge(num, 1, Integer::sum);
                upperSize++;
                upperSum += num;
            }
            balance();
        }

        void remove(int num) {
            if (lower.containsKey(num)) {
                removeValue(lower, num);
                lowerSize--;
                lowerSum -= num;
            } else {
                removeValue(upper, num);
                upperSize--;
                upperSum -= num;
            }
            balance();
        }

        void removeValue(TreeMap<Integer, Integer> map, int num) {
            int count = map.get(num);

            if (count == 1) {
                map.remove(num);
            } else {
                map.put(num, count - 1);
            }
        }

        void balance() {
            while (lowerSize > upperSize + 1) {
                int val = lower.lastKey();

                removeValue(lower, val);
                lowerSize--;
                lowerSum -= val;

                upper.merge(val, 1, Integer::sum);
                upperSize++;
                upperSum += val;
            }

            while (lowerSize < upperSize) {
                int val = upper.firstKey();

                removeValue(upper, val);
                upperSize--;
                upperSum -= val;

                lower.merge(val, 1, Integer::sum);
                lowerSize++;
                lowerSum += val;
            }
        }

        long getCost() {
            int median = lower.lastKey();

            long leftCost = (long) median * lowerSize - lowerSum;
            long rightCost = upperSum - (long) median * upperSize;

            return leftCost + rightCost;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Step 1: Calculate the cost of every window
        long[] cost = new long[n - x + 1];

        DualHeap dh = new DualHeap();

        for (int i = 0; i < x; i++) {
            dh.add(nums[i]);
        }

        cost[0] = dh.getCost();

        for (int i = x; i < n; i++) {
            dh.remove(nums[i - x]);
            dh.add(nums[i]);

            cost[i - x + 1] = dh.getCost();
        }

        // Step 2: Dynamic Programming
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (long[] row : dp) {
            Arrays.fill(row, INF);
        }

        // Zero windows require zero operations
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // Step 3: Find minimum cost
        for (int i = n - 1; i >= 0; i--) {

            for (int j = 1; j <= k; j++) {

                // Option 1: Skip current position
                dp[i][j] = dp[i + 1][j];

                // Option 2: Select window starting at i
                if (i + x <= n &&
                    dp[i + x][j - 1] != INF) {

                    long take = cost[i] + dp[i + x][j - 1];

                    dp[i][j] = Math.min(dp[i][j], take);
                }
            }
        }

        return dp[0][k];
    }
}