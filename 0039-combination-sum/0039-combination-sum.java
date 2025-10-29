class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(0, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void helper(int sum, List<Integer> curr, int[] nums, int target, int idx) {
        if (sum > target) {
            curr.remove(curr.size() - 1);
            return;
        }
        ;
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(sum + nums[i], curr, nums, target, i);
        }
        if (!curr.isEmpty())
            curr.remove(curr.size() - 1);
    }
}