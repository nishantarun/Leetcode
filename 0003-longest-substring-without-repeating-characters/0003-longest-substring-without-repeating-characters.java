class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int a = 0;
        int b = 0;
        int longest = 0;
        while(b < s.length()) {
            if(!set.contains(s.charAt(b))){
                set.add(s.charAt(b));
                b++;
            }
            else {
                longest = Math.max(longest, b-a);
                while(s.charAt(a)!=s.charAt(b)){
                    set.remove(s.charAt(a));
                    a++;
                }
                a++;
                b++;
            }
        }
        return longest = Math.max(longest, b-a);
    }
}