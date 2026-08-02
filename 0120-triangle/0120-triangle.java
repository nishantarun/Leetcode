class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, (int) 1e9);
        }
        return solve(triangle, 0, 0, dp);
    }

    public int solve(List<List<Integer>> triangle, int row, int col, int[][] dp) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        List<Integer> list = triangle.get(row);
        if (dp[row][col] != (int) 1e9)
            return dp[row][col];
        int min = list.get(col);
        int w1 = solve(triangle, row + 1, col, dp);
        int w2 = solve(triangle, row + 1, col + 1, dp);
        min += Math.min(w1, w2);
        return dp[row][col] = min;
    }
}