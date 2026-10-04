class Solution {
    public int subsetXORSum(int[] nums) {
      return solve(nums , 0 , 0);  
    }
    
    private int solve(int[]nums , int index , int xor){
        if(index == nums.length){
            return xor;
        }

        int include = solve(nums , index + 1 , xor ^ nums[index]);
        
        int exclude = solve(nums , index + 1 , xor);
    

    return include + exclude;
}
}
