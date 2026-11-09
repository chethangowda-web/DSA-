class Solution {
    public int rob(int[] nums) {
        int n  = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if(n == 1) return nums[0];
        for(int i = 1; i < n; i++){
            int rob = nums[i];
            if(i > 1){
                rob += dp[i - 2];
            }
            int notRob = dp[i - 1];
            dp[i] = Math.max(rob , notRob);
        }
        return dp[n - 1];
    }
}