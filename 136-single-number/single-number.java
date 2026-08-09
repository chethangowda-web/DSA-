class Solution {
    public int singleNumber(int[] nums) {
        int output = 0;
        int n = nums.length;
        for(int num : nums){
        output = output ^ num;

        }
        
        return output;
    }
}