class Solution {
    public int[] leftRightDifference(int[] nums) {

        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int[] answer = new int[n];
        int leftSum = 0;
        for (int i = 0; i < n; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            answer[i] = Math.abs(leftSum - rightSum);

            leftSum += nums[i];
        }

        return answer;
    }
}