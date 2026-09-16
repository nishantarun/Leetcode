class Solution {
    public String minWindow(String s, String t) {
        int length = Integer.MAX_VALUE;
        int lIdx = 0;
        int rIdx = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int have = 0;
        int need = map.size();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) - 1);
            if (map.get(s.charAt(right)) == 0) {
                have++;
            }
            while (have == need) {
                if (right - left + 1 < length) {
                    length = right - left + 1;
                    lIdx = left;
                    rIdx = right;
                }
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                if (map.get(s.charAt(left)) > 0) {
                    have--;
                }
                left++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(lIdx, rIdx + 1);
    }
}