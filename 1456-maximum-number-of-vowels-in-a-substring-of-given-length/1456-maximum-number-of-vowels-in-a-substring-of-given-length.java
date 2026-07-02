class Solution {
    public int maxVowels(String s, int k) {
        int maxCount = 0;
        int count = 0;

        int left = 0;
        int right = 0;
        while (right < k) {
            if (isVowel(s.charAt(right))) {
                count++;
            }
            right++;
        }
        maxCount = Math.max(maxCount, count);

        while (right < s.length()) {
            if (isVowel(s.charAt(left))) {
                count--;
            }
            left++;
            if (isVowel(s.charAt(right))) {
                count++;
            }
            right++;
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}