class Solution {
    public int numDecodings(String s) {
        int prev;
        int prev2 = 1;
        if (s.charAt(0) == '0')
            prev = 0;
        else
            prev = 1;
        for (int i = 1; i < s.length(); i++) {
            int ways = 0;
            if (s.charAt(i) != '0') {
                ways += prev;
            }
            int num = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (num >= 10 && num <= 26) {
                ways += prev2;
            }
            prev2 = prev;
            prev = ways;
        }
        return prev;
    }
}