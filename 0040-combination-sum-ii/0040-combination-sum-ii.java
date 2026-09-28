class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates, target, 0, list, res);
        return res;
    }

    public void helper(int[] nums, int target, int idx, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (idx == nums.length || target < 0) {
            return;
        }
        list.add(nums[idx]);
        helper(nums, target - nums[idx], idx + 1, list, res);
        list.removeLast();
        while (idx + 1 < nums.length && nums[idx + 1] == nums[idx]) {
            idx++;
        }
        helper(nums, target, idx + 1, list, res);
    }
}