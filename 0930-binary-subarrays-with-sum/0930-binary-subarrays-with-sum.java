class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int a = solver(nums, goal);
        int b = solver(nums, goal - 1);
        return a - b;
    }

    private int solver(int[] nums, int k) {
        if (k < 0)
            return 0;
        int totalCount = 0;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            totalCount += right - left + 1;
        }
        return totalCount;
    }
}