class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] maxarr = new int[n];
        int maxRight = prices[n - 1];
        maxarr[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxarr[i] = maxRight;
            maxRight = Math.max(maxRight, prices[i]);
        }
        int maxProfit = 0;
        int profit = 0;
        for (int i = 0; i < n; i++) {
            profit = maxarr[i] - prices[i];
            maxProfit = Math.max(profit, maxProfit);
        }
        maxProfit = Math.max(profit, maxProfit);
        return maxProfit;
    }
}