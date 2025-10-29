class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(0, n, new ArrayList<>(), k, 1);
        return res;
    }

    public void helper(int sum, int target, List<Integer> curr, int length, int idx) {
        if(sum > target) {
            return;
        }
        if(curr.size() == length && sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx; i < 10; i++) {
            curr.add(i);
            helper(sum + i, target, curr, length, i + 1);
            curr.remove(curr.size()-1);
        }
    }
}