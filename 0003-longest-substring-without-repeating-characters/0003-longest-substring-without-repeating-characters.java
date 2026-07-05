class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        int left = 0;
        int right = 0;
        for (right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right)) && left != right) {
                ans = Math.max(ans, right - left);
                set.remove(s.charAt(left));
                left++;
            }
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
            }
        }
        ans = Math.max(ans, right - left);
        return ans;
    }
}