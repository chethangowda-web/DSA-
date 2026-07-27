class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int [] ahead = new int[2];
        for(int i = n - 1; i >= 0; i--){
            int[] curr  = new int[2];
            int buy = -prices[i] + ahead[0];
            int notbuy = ahead[1];
            curr[1] = Math.max(buy , notbuy);

            int sell = prices[i] - fee + ahead[1];
            int notsell = ahead[0];
            curr[0] = Math.max(sell , notsell);
            ahead = curr;
         }
         
         return ahead[1];
    }

}