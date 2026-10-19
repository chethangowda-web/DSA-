class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0; i < n - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];

                if(sum == 0){
                    result.add(Arrays.asList(nums[left] , nums[right] , nums[i]));
                    left++;
                    right--;
                     while(left < right && nums[left] == nums[left - 1]){
                left++;
            }

            while(left < right && nums[right] == nums[right + 1]){
                right--;
            }
        }else if(sum < 0){
            left++;
        }else{
            right--;
        }
    }
        }
    return result;
}
}