class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = matrix[i][j];
                int leftD = Integer.MAX_VALUE;
                if (j > 0) {
                    leftD = dp[i - 1][j - 1];
                }
                int up = dp[i - 1][j];
                int rightD = Integer.MAX_VALUE;
                if (j < n - 1) {
                    rightD = dp[i - 1][j + 1];
                }
                min += Math.min(leftD, Math.min(up, rightD));
                dp[i][j] = min;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        
        return min;
    }
}