class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (c != chars[i]) {
                sb.append(c + "");
                if (count != 1) {
                    sb.append(count);
                }
                count = 1;
                c = chars[i];
            } else {
                count++;
            }
        }
        sb.append(c);
        if (count != 1) {
            sb.append(count);
        }
        String s = sb.toString();
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return s.length();
    }
}