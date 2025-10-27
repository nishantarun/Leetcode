class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> tempList = new ArrayList<>();
        helper(tempList, 1, n, k);
        return list;
    }

    public void helper(List<Integer> tempList, int idx, int n, int k) {
        if (tempList.size() == k) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = idx; i <= n; i++) {
            tempList.add(i);
            helper(tempList, i+1, n, k);
            tempList.remove(tempList.size() - 1);
        }
    }
}