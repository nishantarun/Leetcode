class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }
    public int helper(int[] nums, int target, int curr, int idx) {
        if(idx == nums.length && curr == target) {
            return 1;
        }
        if(idx == nums.length) {
            return 0;
        }

        int sub = helper(nums, target, curr - nums[idx], idx + 1);
        int add = helper(nums, target, curr + nums[idx], idx + 1);
        return sub + add;
    }
}