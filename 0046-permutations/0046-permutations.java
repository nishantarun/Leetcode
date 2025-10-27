class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> tempList = new ArrayList<>();
        helper(tempList, nums);
        return list;
    }

    public void helper(List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i]))
                continue;
            tempList.add(nums[i]);
            helper(tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}