class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
      int left = 0;
        int ans = 0;

for (int right = 0; right < nums.length; right++) {
    if (nums[right] == 0) {
        left = right + 1;
    }

    ans = Math.max(ans, right - left + 1);

}

return ans;
    }
}
