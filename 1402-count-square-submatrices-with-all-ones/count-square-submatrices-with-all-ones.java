class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
       
       int[]next = new int[n + 1];
       int count = 0;
       for(int i = m - 1; i >= 0; i--){
        int [] curr = new int[n + 1];
        for(int j = n - 1; j >= 0; j--){
            if(matrix[i][j] == 1){
                int right = curr[j + 1];
                int down = next[j];
                int diagonal = next[j + 1];

                curr[j] = 1 + Math.min(right , Math.min(down , diagonal));
            }else{
                curr[j] = 0;
            }

            count += curr[j];
        }
        next  = curr;
       }
       return count;
    }
}

