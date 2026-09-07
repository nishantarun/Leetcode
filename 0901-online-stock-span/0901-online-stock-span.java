class StockSpanner {
    public ArrayList<Integer> list;

    public StockSpanner() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);
        int count = 0;
        int i = list.size() - 1;
        while (i >= 0 && price >= list.get(i)) {
            count++;
            i--;
        }
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */