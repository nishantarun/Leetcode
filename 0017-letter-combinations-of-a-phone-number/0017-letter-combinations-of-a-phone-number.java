class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        helper(map, digits, 0, "");

        return res;
    }

    public void helper(HashMap<Character, String> map, String digits, int idx, String curr) {
        if (idx == digits.length()) {
            res.add(curr);
            return;
        }

        String letters = map.get(digits.charAt(idx));

        for (char ch : letters.toCharArray()) {
            helper(map, digits, idx + 1, curr + ch);
        }
    }
}