class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // Find cheapest item
        int minPrice = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < n; i++) {
            if (items[i][1] < minPrice) {
                minPrice = items[i][1];
                minIndex = i;
            }
        }

        // Calculate free items for every item type
        int[] free = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i != j && items[j][0] % items[i][0] == 0) {
                    free[i]++;
                }
            }
        }

        // dp[0] = cheapest item not selected
        // dp[1] = cheapest item selected
        int[][] dp = new int[2][budget + 1];

        for (int i = 0; i < 2; i++) {
            java.util.Arrays.fill(dp[i], -1000000);
        }

        dp[0][0] = 0;

        // 0/1 Knapsack
        for (int i = 0; i < n; i++) {

            int price = items[i][1];
            int reward = 1 + free[i];

            for (int cost = budget; cost >= price; cost--) {

                for (int flag = 0; flag <= 1; flag++) {

                    if (dp[flag][cost - price] == -1000000) {
                        continue;
                    }

                    int newFlag = flag;

                    if (i == minIndex) {
                        newFlag = 1;
                    }

                    dp[newFlag][cost] = Math.max(
                        dp[newFlag][cost],
                        dp[flag][cost - price] + reward
                    );
                }
            }
        }

        int ans = 0;

        // Calculate maximum obtainable items
        for (int cost = 0; cost <= budget; cost++) {

            int remaining = budget - cost;

            // Cheapest item already selected
            if (dp[1][cost] != -1000000) {

                int total = dp[1][cost] + remaining / minPrice;

                ans = Math.max(ans, total);
            }

            // Cheapest item not selected
            if (dp[0][cost] != -1000000) {

                int extraCopies = remaining / minPrice;

                int total = dp[0][cost] + extraCopies;

                // Buying the cheapest item activates its free reward
                if (extraCopies > 0) {
                    total += free[minIndex];
                }

                ans = Math.max(ans, total);
            }
        }

        return ans;
    }
}