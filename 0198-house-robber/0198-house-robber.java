class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, nums.length-1, dp);
    }

    public int helper(int[] nums, int idx, int[] dp) {
        if (idx < 0) return 0;
        if (dp[idx] != -1) return dp[idx];
        int take = nums[idx] + helper(nums, idx - 2, dp);
        int notTake = helper(nums, idx - 1, dp);
        return dp[idx] = Math.max(take, notTake);
    }
}