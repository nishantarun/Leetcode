class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(0, new ArrayList<>(), nums);
        return res;
    }

    public void helper(int idx, List<Integer> curr, int[] nums) {
        res.add(new ArrayList<>(curr));

        for(int i = idx; i < nums.length; i++) {
            if(i > idx && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            helper(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
}