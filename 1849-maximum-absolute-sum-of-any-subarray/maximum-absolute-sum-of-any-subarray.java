class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int currentMax = nums[0];
        int currentMin = nums[0];
        int ans = Math.abs(nums[0]);
        for(int i = 1; i < n; i++){
            currentMax = Math.max(nums[i] , currentMax + nums[i]);
            currentMin = Math.min(nums[i] , currentMin + nums[i]);
            ans = Math.max(ans, Math.max(currentMax , -currentMin));
        }

        return ans;
    }

}