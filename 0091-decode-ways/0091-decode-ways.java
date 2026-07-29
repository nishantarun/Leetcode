class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, s.length() - 1, dp);
    }

    public int helper(String s, int n, int[] dp) {
        if (n < 0)
            return 1;
        if (n == 0)
            return s.charAt(0) == '0' ? 0 : 1;
        if (dp[n] != -1)
            return dp[n];
        int ways = 0;
        if (s.charAt(n) != '0') {
            ways += helper(s, n - 1, dp);
        }
        if (n > 0) {
            int num = (s.charAt(n - 1) - '0') * 10 + (s.charAt(n) - '0');
            if (num >= 10 && num <= 26) {
                ways += helper(s, n - 2, dp);
            }
        }
        return dp[n] = ways;
    }
}