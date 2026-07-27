class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[]row : dp){
                Arrays.fill(row, -1);
            }
        return solve(0 , 1 ,  fee , prices , dp);
    }
    private int solve(int i ,int canbuy ,  int fee , int[] prices , int[][] dp){

        if(i == prices.length)
            return 0;
        
        if(dp[i][canbuy] != -1)
            return dp[i][canbuy];

        if(canbuy == 1){
            int buy = -prices[i] + solve(i + 1 , 0,fee, prices , dp);
            int notbuy = solve(i + 1 , 1 , fee , prices , dp);
            dp[i][canbuy]  = Math.max(buy , notbuy);
        }else{
            int sell = prices[i] - fee + solve(i + 1 , 1 , fee , prices ,dp);
            int notsell = solve(i + 1 , 0 , fee , prices , dp);
            dp[i][canbuy] =  Math.max(sell , notsell);
        }
        return dp[i][canbuy];
    }
}