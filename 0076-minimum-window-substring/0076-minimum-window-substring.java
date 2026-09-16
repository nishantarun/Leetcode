class Solution {

    public String minWindow(String s, String t) {
        int length = Integer.MAX_VALUE;
        int lIdx = 0;
        int rIdx = 0;

        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        int have = 0;
        int need = 0;
        for (int i = 0; i < 128; i++) {
            if (map[i] > 0) {
                need++;
            }
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map[c]--;
            if (map[c] == 0) {
                have++;
            }
            while (have == need) {
                if (right - left + 1 < length) {
                    length = right - left + 1;
                    lIdx = left;
                    rIdx = right;
                }
                char leftChar = s.charAt(left);
                map[leftChar]++;
                if (map[leftChar] > 0) {
                    have--;
                }
                left++;
            }
        }

        return length == Integer.MAX_VALUE ? "" : s.substring(lIdx, rIdx + 1);
    }
}