class Solution {
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                dq.push(c);
            }
            else {
                if(dq.isEmpty()){
                    return false;
                }
                char top = dq.peek();
                if(c == ')' && top == '(' || c == '}' && top == '{' || c == ']' && top == '['){
                    dq.pop();
                }
                else {
                    return false;
                }
            }
        }
        return dq.isEmpty() ? true : false;
    }
}