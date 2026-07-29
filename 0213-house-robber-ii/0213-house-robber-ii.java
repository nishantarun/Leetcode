class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int notTakingLast = helper(nums, 0, n - 2);
        int notTakingFirst = helper(nums, 1, n - 1);
        return Math.max(notTakingFirst, notTakingLast);
    }

    public int helper(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, start, end, dp);
    }

    public int solve(int[] nums, int start, int end, int[] dp){
        if(end < start) return 0;
        if(end == start) return nums[start];
        if(dp[end] != -1) return dp[end];
        int take = nums[end] + solve(nums, start, end - 2, dp);
        int notTake = solve(nums, start, end - 1, dp);
        return dp[end] = Math.max(take, notTake);
    }
}