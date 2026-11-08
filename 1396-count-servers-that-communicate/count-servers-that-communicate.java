class Solution {
    public int countServers(int[][] grid) {
       int rows = grid.length;
       int cols = grid[0].length;

       int[] rowcount = new int[rows];
       int[] colcount = new int[cols];

       for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
            if(grid[i][j] == 1){
                rowcount[i]++;
                colcount[j]++;
            }
        }
       }

       int count = 0;
       for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
            if(grid[i][j] == 1 && (rowcount[i] > 1 || colcount[j] > 1)){
                count++;
            }
        }
       }
       return count;
    }
}