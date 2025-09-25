class Solution {
    public String largestOddNumber(String s) {
        int idx = -1;
        for(int i = s.length()-1; i>=0; i--) {
            int num = (int)s.charAt(i);
            if(num % 2 != 0) {
                idx = i+1;
                break;
            }
        }
        if(idx == -1) {
            return "";
        }
        return s.substring(0, idx);
    }
}