class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int ele : piles) {
            if (right < ele) {
                right = ele;
            }
        }
        int ans = right;
        while (left <= right) {
            int curr = left + (right - left) / 2;
            if (canFinishPiles(piles, h, curr)) {
                ans = curr;
                right = curr - 1;
            } else {
                left = curr + 1;
            }
        }
        return ans;
    }

    public boolean canFinishPiles(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / k);
        }
        return hours <= h;
    }
}