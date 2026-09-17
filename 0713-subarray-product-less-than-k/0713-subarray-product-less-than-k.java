class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2) {
            return 0;
        }
        int target = k - 1;
        int ans = 0;
        int prod = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod > target) {
                prod /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
