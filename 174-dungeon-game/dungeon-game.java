class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        // Reverse DP
        // minimum health to save pricess
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n -1 ; j >= 0; j--){
                if(i == m - 1 && j == n - 1)
                    dp[i][j] = Math.min(0 , dungeon[i][j]);

                else if(i == m - 1)
                    dp[i][j] = Math.min(0 , dungeon[i][j] + dp[i][j + 1]);
                else if(j == n - 1)
                    dp[i][j] = Math.min(0 , dungeon[i][j] + dp[i + 1][j]);
                else
                    dp[i][j] = Math.min(0 , dungeon[i][j] + Math.max(dp[i][j + 1] , dp[i + 1][j]));
            }
        }
        return Math.abs(dp[0][0]) + 1;
        }
    }
