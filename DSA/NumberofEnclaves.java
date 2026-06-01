class Solution {
    private int m , n;
    public int numEnclaves(int[][] grid) {
        // any land cell that are on the boundary that can escape
        m = grid.length;
        n = grid[0].length;

        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1) dfs(grid , i , 0);
            if(grid[i][n - 1] == 1) dfs(grid , i , n - 1);
        }

        for(int j = 0; j < n; j++){
            if(grid[0][j] == 1) dfs(grid , 0 , j);
            if(grid[m - 1][j] == 1) dfs(grid , m - 1 , j); 
        }

        int count = 0; 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid , int r , int c){
        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != 1){
            return;
        }
        grid[r][c] = 0;

        dfs(grid , r + 1 , c);
        dfs(grid , r - 1 , c);
        dfs(grid , r , c + 1);
        dfs(grid , r , c - 1);
    }
}