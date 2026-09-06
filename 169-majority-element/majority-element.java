class Solution {
    public int majorityElement(int[] nums) {
        int maxEle = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                maxEle = nums[i];
            }
            if(nums[i] == maxEle){
                count++;
            }else{
                count--;
            }
        }
        return maxEle;
    }
}