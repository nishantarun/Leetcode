class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(0, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void helper(int sum, List<Integer> curr, int[] nums, int target, int idx) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1])
                continue;
            curr.add(nums[i]);
            helper(sum + nums[i], curr, nums, target, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}