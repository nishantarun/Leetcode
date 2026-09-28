class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums, 0, list, res);
        return res;
    }

    public void helper(int[] nums, int idx, List<Integer> list, List<List<Integer>> res) {
        if (idx == nums.length) {
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
            return;
        }
        list.add(nums[idx]);
        helper(nums, idx + 1, list, res);
        list.removeLast();
        helper(nums, idx + 1, list, res);
    }
}