class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i]) {
                    if (dp[prev] + 1 > dp[i]) {
                        dp[i] = dp[prev] + 1;
                        count[i] = count[prev];
                    }
                    else if (dp[prev] + 1 == dp[i]) {
                        count[i] += count[prev];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                ans += count[i];
            }
        }
        return ans;
    }
}