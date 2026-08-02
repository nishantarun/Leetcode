class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(grid, m - 1, n - 1, dp);
    }

    public int solve(int[][] grid, int row, int col, int[][] dp) {
        if (row < 0 || col < 0) {
            return (int) 1e9;
        }
        if (row == 0 && col == 0) {
            return grid[0][0];
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int up = grid[row][col] + solve(grid, row - 1, col, dp);
        int left = grid[row][col] + solve(grid, row, col - 1, dp);
        return dp[row][col] = Math.min(up, left);
    }
}