class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return solve(nums, target, n - 1);
    }

    public int solve(int[] nums, int target, int n) {
        if (n < 0) {
            return target == 0 ? 1 : 0;
        }
        int add = solve(nums, target - nums[n], n - 1);
        int sub = solve(nums, target + nums[n], n - 1);
        return add + sub;
    }
}