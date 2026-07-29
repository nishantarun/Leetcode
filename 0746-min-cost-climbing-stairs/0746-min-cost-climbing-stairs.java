class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int oneStep = cost[i - 1] + dp[i - 1];
            int twoStep = cost[i - 2] + dp[i - 2];
            dp[i] = Math.min(oneStep, twoStep);
        }
        return dp[n];
    }

    public int helper(int[] cost, int n, int[] dp) {
        if (n <= 1)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int oneStep = cost[n - 1] + helper(cost, n - 1, dp);
        int twoStep = cost[n - 2] + helper(cost, n - 2, dp);
        return dp[n] = Math.min(oneStep, twoStep);
    }
}