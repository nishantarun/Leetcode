class StockSpanner {
    public Deque<int[]> stack;
    int currIdx = 0;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        while (!stack.isEmpty() && price >= stack.peek()[1]) {
            stack.pop();
        }
        int ans = stack.isEmpty() ? currIdx + 1 : currIdx - stack.peek()[0];
        stack.push(new int[] { currIdx, price });
        currIdx++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */