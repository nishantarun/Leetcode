class Solution {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        String s = "";
        helper(s, 0, 0, n);
        return list;
    }

    public void helper(String s, int lcount, int rcount, int n) {
        if (s.length() == 2 * n) {
            list.add(s);
            return;
        }
        if (lcount < n) {
            helper(s + "(", lcount + 1, rcount, n);
        }
        if (rcount < lcount) {
            helper(s + ")", lcount, rcount + 1, n);
        }
    }
}