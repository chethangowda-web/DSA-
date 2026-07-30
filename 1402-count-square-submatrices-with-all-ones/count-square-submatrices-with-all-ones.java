class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int count = 0;
        for(int i = m -1 ; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int right = dp[i][j + 1];
                int down = dp[i + 1][j];
                int diagonal = dp[i+ 1][j + 1];
                if(matrix[i][j] == 1){
                    dp[i][j] = 1 + Math.min(right , Math.min(down , diagonal));
                }else{
                    dp[i][j] = 0;
                }
                  count += dp[i][j];
            }
        }
        return count;
        }
}
    