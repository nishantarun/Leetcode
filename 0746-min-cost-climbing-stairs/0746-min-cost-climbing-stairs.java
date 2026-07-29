class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return helper(cost, cost.length, dp);
    }

    public int helper(int[] cost, int n, int[] dp) {
        if (n <= 1)
            return 0;
        if(dp[n] != -1) return dp[n];
        int oneStep = cost[n - 1] + helper(cost, n - 1, dp);
        int twoStep = cost[n - 2] + helper(cost, n - 2, dp);
        return dp[n] = Math.min(oneStep, twoStep);
    }
}