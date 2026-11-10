class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, costs, dp);
    }
    private int solve(int i , int[]costs , int []dp){
        if(i==0) return 0;
        if(dp[i] != -1) return dp[i];
        int minCost = 808986986;
        for(int j = 1; j <= 3; j++){
            if(i - j >= 0){
            int cost = solve(i - j , costs , dp) + costs[i - 1] + j * j;
            minCost = Math.min(minCost , cost);
        }
    }
     return dp[i] = minCost;
    }
   
}
