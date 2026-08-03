class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                int min = list.get(j);
                int up = Integer.MAX_VALUE;
                if (j < i) {
                    up = dp[i - 1][j];
                }
                int rightD = Integer.MAX_VALUE;
                if (j > 0) {
                    rightD = dp[i - 1][j - 1];
                }
                min += Math.min(up, rightD);
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