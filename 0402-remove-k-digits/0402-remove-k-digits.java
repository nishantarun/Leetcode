class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int number = num.charAt(i) - '0';
            while (!stack.isEmpty() && k > 0 && number < stack.peek()) {
                k--;
                stack.pop();
            }
            stack.push(number);
        }

        while (k-- > 0) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        String result = sb.substring(i);

        return result.isEmpty() ? "0" : result;
    }
}