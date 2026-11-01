class Solution {
    public int minMoves(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        for(int num : nums){
            minNum = Math.min(minNum , num);
        }
        int moves = 0;
        for(int num : nums){
            moves += (num - minNum);
        }

        return moves;
    }
}