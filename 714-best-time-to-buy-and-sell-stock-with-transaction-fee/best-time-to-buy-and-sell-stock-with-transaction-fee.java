class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i = n - 1; i >= 0; i--){
            int buy = -prices[i] + dp[i + 1][0];
            int notbuy = dp[i + 1][1];
            dp[i][1] = Math.max(buy , notbuy);

            int sell = prices[i] - fee + dp[i + 1][1];
            int notsell = dp[i + 1][0];
            dp[i][0] = Math.max(sell , notsell);
         }
         return dp[0][1];
    }
}