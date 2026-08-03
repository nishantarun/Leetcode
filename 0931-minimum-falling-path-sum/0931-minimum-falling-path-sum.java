class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                int min = matrix[i][j];
                int leftD = Integer.MAX_VALUE;
                if (j > 0) {
                    leftD = prev[j - 1];
                }
                int up = prev[j];
                int rightD = Integer.MAX_VALUE;
                if (j < n - 1) {
                    rightD = prev[j + 1];
                }
                min += Math.min(leftD, Math.min(up, rightD));
                curr[j] = min;
            }
            prev = curr;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prev[i]);
        }

        return min;
    }
}