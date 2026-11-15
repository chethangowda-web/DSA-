class Solution {
    public int numOfSubarrays(int[] arr) {
       int even = 1;
       int odd = 0;
       int prefixSum = 0;
       int MOD = 1000000007;
       int result = 0;

       for(int num : arr){
        prefixSum += num;
        if(prefixSum % 2 == 0){
            result = (result + odd) % MOD;
            even++;
        }else{
            result = (result + even) % MOD;
            odd++;
        }
       }
       return result;
    }
}