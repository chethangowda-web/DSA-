class Solution {
    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        long sum = 0;
        for(int i = 0; i< n; i++){
            int smallest = arr[i];
            int largest = arr[i];

            for(int j = i; j < n; j++){
                smallest = Math.min(smallest , arr[j]);
                largest = Math.max(largest , arr[j]);

                sum += (largest - smallest);
            }
        }
        return sum;
    }
}