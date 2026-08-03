class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, solve(matrix, n - 1, i, dp));
        }
        return min;
    }

    public int solve(int[][] matrix, int row, int col, int[][] dp) {
        if (col < 0 || col > matrix.length - 1) {
            return (int) 1e9;
        }
        if (row == 0) {
            return matrix[0][col];
        }
        if (dp[row][col] != Integer.MAX_VALUE)
            return dp[row][col];
        int min = matrix[row][col];
        int leftD = solve(matrix, row - 1, col - 1, dp);
        int up = solve(matrix, row - 1, col, dp);
        int rightD = solve(matrix, row - 1, col + 1, dp);
        min += Math.min(leftD, Math.min(up, rightD));
        return dp[row][col] = min;
    }
}