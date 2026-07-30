class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        return solve(0 , arr , k , dp);
    }
    private int solve(int i , int[]arr , int k , int[]dp){
        if(i == arr.length)
            return 0;

        if(dp[i] != -1)
            return dp[i];

        int maxAns = 0;
        int currentMax = 0;
        int length = 0;

        for(int j = i ; j < Math.min(i + k , arr.length); j++){
            length++;
            currentMax = Math.max(currentMax  , arr[j]);
            int sum = currentMax * length + solve(j + 1 , arr , k , dp);

            maxAns = Math.max(maxAns , sum);
        }

        return dp[i] =  maxAns;
    }
}