class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;

        int left = 0;
        int right = n1;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i = 0; i < n1; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        while (right < n2) {
            if (Arrays.equals(freq1, freq2)) return true;
            freq2[s2.charAt(right) - 'a']++;
            right++;
            freq2[s2.charAt(left) - 'a']--;
            left++;
        }

        return Arrays.equals(freq1, freq2);
    }
}