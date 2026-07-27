class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] front1 = new int[2];
        int[] front2 = new int[2];

        for(int i = n - 1; i>= 0; i--){
            int[] curr = new int[2];

            int buy = -prices[i] + front1[0];
            int notbuy = front1[1];
            curr[1] = Math.max(buy , notbuy);

            int sell = prices[i] + front2[1];
            int notsell = front1[0];
            curr[0] = Math.max(sell , notsell);

            front2 = front1;
            front1 = curr;
        }
        return front1[1];
    }
}