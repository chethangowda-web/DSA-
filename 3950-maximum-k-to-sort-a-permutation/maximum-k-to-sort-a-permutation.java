class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int k = (1 << 30) - 1;
        boolean alreadySorted = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                k &= nums[i];
                alreadySorted = false;
            }
        }

        return alreadySorted ? 0 : k;
    }
}