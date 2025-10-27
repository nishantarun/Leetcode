class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> tempList = new ArrayList<>();
        List<Integer> idxList = new ArrayList<>();
        helper(tempList, idxList, nums);
        return list;
    }

    public void helper(List<Integer> tempList, List<Integer> idxList, int[] nums) {
        if (tempList.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(tempList);
            if (!list.contains(temp))
                list.add(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (idxList.contains(i))
                continue;
            idxList.add(i);
            tempList.add(nums[i]);
            helper(tempList, idxList, nums);
            idxList.remove(idxList.size() - 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}