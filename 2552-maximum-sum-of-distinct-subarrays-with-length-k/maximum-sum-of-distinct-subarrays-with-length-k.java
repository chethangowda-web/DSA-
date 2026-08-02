class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        long sum = 0;
        long ans = 0;

        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            if (right - left + 1 > k) {
                sum -= nums[left];
                freq.put(nums[left], freq.get(nums[left]) - 1);

                if (freq.get(nums[left]) == 0)
                    freq.remove(nums[left]);

                left++;
            }

            if (right - left + 1 == k && freq.size() == k) {
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}