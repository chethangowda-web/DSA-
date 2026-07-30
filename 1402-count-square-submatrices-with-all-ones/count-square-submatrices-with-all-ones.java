class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row , - 1);
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                count += solve(i  , j , matrix , dp);
            }
        }
            return count;
        }
    private int solve(int i , int j  , int[][]matrix , int[][]dp){
        int m = matrix.length;
        int n = matrix[0].length;

        if(i >= m || j >= n)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
    

        int right = solve(i  , j + 1 , matrix , dp);
        int down = solve(i + 1, j , matrix , dp);    
        int diagonal = solve(i + 1 , j + 1 , matrix ,dp);

        if(matrix[i][j] == 0)
            return dp[i][j] = 0;

        return dp[i][j] = 1 + Math.min(right , Math.min(down , diagonal));

        }
}