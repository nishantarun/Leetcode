class Solution {
    public int climbStairs(int n) {
        int prev = 1;
        int secPrev = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev + secPrev;
            secPrev = prev;
            prev = curr;
        }
        return prev;
    }
}