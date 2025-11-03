class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return maze(grid, 0, 0, grid.length, grid[0].length, dp);
    }

    public static int maze(int[][] grid, int row, int col, int m, int n, int[][] dp) {
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return 0;
        }
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        int x = 0, y = 0;

        if (isSafeRight(grid, row, col, m, n)) {
            x = maze(grid, row, col + 1, m, n, dp);
        }
        if (isSafeDown(grid, row, col, m, n)) {
            y = maze(grid, row + 1, col, m, n, dp);
        }

        return dp[row][col] = x + y;
    }

    public static boolean isSafeRight(int[][] grid, int row, int col, int m, int n) {
        if (col < n - 1 && grid[row][col + 1] != 1) {
            return true;
        }
        return false;
    }

    public static boolean isSafeDown(int[][] grid, int row, int col, int m, int n) {
        if (row < m - 1 && grid[row + 1][col] != 1) {
            return true;
        }
        return false;
    }
}