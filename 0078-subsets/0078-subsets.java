class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        helper(0, curr, nums);
        return list;
    }

    public void helper(int idx, List<Integer> currList, int[] nums) {
        if (idx == nums.length) {
            list.add(new ArrayList<>(currList));
            return;
        }

        currList.add(nums[idx]);
        helper(idx + 1, currList, nums);
        currList.remove(currList.size() - 1);
        helper(idx + 1, currList, nums);
    }
}