class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] nextWarm = new int[n];
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack1.isEmpty() && temperatures[i] >= stack1.peek()) {
                stack1.pop();
                stack2.pop();
            }
            if (stack1.isEmpty()) {
                nextWarm[i] = 0;
            } else {
                nextWarm[i] = stack2.peek() - i;
            }
            stack1.push(temperatures[i]);
            stack2.push(i);
        }
        return nextWarm;
    }
}