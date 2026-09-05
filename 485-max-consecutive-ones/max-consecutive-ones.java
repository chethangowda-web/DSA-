class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int Ones =  0;
        int MaxOnes = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                Ones++;
            }else{
                Ones = 0;
            }
            if(Ones > MaxOnes){
                MaxOnes = Ones;
            }
        }
            return MaxOnes;
    }
}