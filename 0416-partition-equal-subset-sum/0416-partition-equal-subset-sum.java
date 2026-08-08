class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int ele : nums) {
            sum += ele;
        }

        if (sum % 2 != 0)
            return false;

        int[][] dp = new int[sum / 2 + 1][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        if (nums[0] <= sum / 2) {
            dp[nums[0]][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= sum / 2; target++) {
                int notTake = dp[target][i - 1];
                int take = 0;
                if (nums[i] <= target) {
                    take = dp[target - nums[i]][i - 1];
                }
                dp[target][i] = take | notTake;
            }
        }

        return dp[sum / 2][n - 1] == 1;
    }
}