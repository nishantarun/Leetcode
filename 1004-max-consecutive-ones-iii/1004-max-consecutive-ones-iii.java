class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int flips = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] == 0 && flips == k) {
                if (nums[left] == 0) {
                    flips--;
                }
                left++;
            }
            if (nums[right] == 0) {
                flips++;
            }
            int length = right - left + 1;
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}