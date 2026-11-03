class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        for(int n : nums){
            if(n > max){
                max = n;
            }
        }
        int moves = 0;
        for(int n : nums){
            moves  += max - n;
        }
        return moves;
    }
}