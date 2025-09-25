class Solution {
    public String countAndSay(int n) {
        return helper("1", n);
    }

    public String helper(String s, int n) {
        if(n == 1) return s;
        String res = "";
        int count = 1;
        char c = s.charAt(0);
        for(int i = 1; i< s.length(); i++) {
            if(s.charAt(i) == c) {
                count++;
            }
            else {
                res = res + count + c;
                c = s.charAt(i);
                count = 1;
            }
        }
        res = res + count + c;
        return helper(res, n-1);
    }
}