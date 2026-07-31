class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for(int i= n - 1; i >= 0; i--){

        int maxAns = 0;
        int currentMax = 0;
        int length = 0;

        for(int j = i ; j < Math.min(i + k , n); j++){
            length++;
            currentMax = Math.max(currentMax  , arr[j]);
            int sum = currentMax * length + dp[j + 1];

            maxAns = Math.max(maxAns , sum);
        }
        dp[i] = maxAns;
        }
        return dp[0];
    }
}