class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int a = solver(nums, k);
        int b = solver(nums, k - 1);
        return a - b;
    }

    public int solver(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int res = 0;
        int oddCount = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) {
                oddCount++;
            }
            while (oddCount > k) {
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}