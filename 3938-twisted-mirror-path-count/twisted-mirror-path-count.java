class Solution {
    private static final int MODULO = 1_000_000_007;

    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] right = new int[m][n];
        int[][] down = new int[m][n];

        right[0][0] = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (i == m - 1 && j == n - 1) {
                    return (right[i][j] + down[i][j]) % MODULO;
                }

                int r = right[i][j];
                int d = down[i][j];

                if (grid[i][j] == 0) {

                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + r + d) % MODULO;
                    }

                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + r + d) % MODULO;
                    }

                } else {

                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + d) % MODULO;
                    }

                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + r) % MODULO;
                    }
                }
            }
        }

        return 0;
    }
}