class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int ele : nums) {
            sum += ele;
        }

        if(sum % 2 != 0) return false;
    
        int[][] dp = new int[sum/2 + 1][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums, sum / 2, n - 1, dp);
    }

    public boolean solve(int[] nums, int target, int n, int[][] dp) {
        if (n == 0) {
            return nums[0] == target;
        }
        if (target == 0) {
            return true;
        }
        if(dp[target][n] != -1) return dp[target][n] == 1;
        boolean notTake = solve(nums, target, n - 1, dp);
        boolean take = false;
        if (nums[n] <= target) {
            take = solve(nums, target - nums[n], n - 1, dp);
        }
        dp[target][n] = take || notTake ? 1: 0;
        return take || notTake;
    }
}