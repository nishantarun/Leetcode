class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        int k = p.length();
        for (int i = 0; i < k; i++) {
            freq2[p.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;

        while (right < k) {
            freq1[s.charAt(right) - 'a']++;
            right++;
        }
        if (Arrays.equals(freq1, freq2)) {
            res.add(left);
        }
        while (right < s.length()) {
            freq1[s.charAt(left) - 'a']--;
            left++;
            freq1[s.charAt(right) - 'a']++;
            right++;
            if (Arrays.equals(freq1, freq2)) {
                res.add(left);
            }
        }

        return res;
    }
}