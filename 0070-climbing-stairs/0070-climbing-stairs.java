class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return helper(0, n, dp);
    }

    public int helper(int curr, int n, int[] dp) {
        if(curr > n) {
            return 0;
        }
        if(dp[curr] != 0) {    
            return dp[curr];
        }

        if(curr == n) {
            return 1;
        }

        int x = helper(curr + 1, n, dp);
        int y = helper(curr + 2, n, dp);

        return dp[curr] = x + y;
    }
}