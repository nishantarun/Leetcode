class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }
    public int helper(int[] nums, int target, int curr, int idx) {
        if(idx == nums.length) {
            return curr == target ? 1 : 0;
        }

        String key = curr + "," + idx;
        if(memo.containsKey(key)) return memo.get(key);

        int sub = helper(nums, target, curr - nums[idx], idx + 1);
        int add = helper(nums, target, curr + nums[idx], idx + 1);

        memo.put(key, add + sub);
        return sub + add;
    }
}