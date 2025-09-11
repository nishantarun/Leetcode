class Solution {
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        int ans = helper(x, 1, x);
        return ans;
    }

    public int helper(int x, int left, int right) {
        if(left > right) {
            return right;
        }
        int mid = left + (right - left) / 2;
        long midsqr = (long)mid*mid;
        if(midsqr == x) {
            return mid;
        }
        else if (midsqr > x) {
            return helper(x, left, mid-1);
        }
        else {
            return helper(x, mid +1, right);
        }
    }
}