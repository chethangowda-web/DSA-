class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int minProduct = nums[0];
        int maxProduct = nums[0];
        int ans = nums[0];

        for(int i = 1; i < n; i++){
            int newMax = Math.max(nums[i] , Math.max( maxProduct * nums[i] , minProduct * nums[i]));
            int newMin = Math.min(nums[i] , Math.min(minProduct * nums[i] , maxProduct *  nums[i]));

            maxProduct = newMax;
            minProduct = newMin;

            ans = Math.max(ans, newMax);
        }

        return ans;
    }
}