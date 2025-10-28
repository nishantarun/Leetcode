class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        helper(0, temp, nums);
        return res;
    }

    public void helper(int idx, List<Integer> temp, int[] nums) {
        if(idx == nums.length) {
            List<Integer> ls = new ArrayList<>(temp);
            if(!res.contains(ls)){
                res.add(ls);
            }
            return;
        }
        temp.add(nums[idx]);
        helper(idx + 1, temp, nums);
        temp.remove(temp.size()-1);
        helper(idx + 1, temp, nums);
    }
}