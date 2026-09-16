class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int a = solver(nums, k);
        int b = solver(nums, k - 1);
        return a - b;
    }

    private int solver(int[] nums, int k) {
        int res = 0;
        int[] freq = new int[nums.length + 1];
        int distinct = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (freq[nums[right]] == 0) {
                distinct++;
            }
            freq[nums[right]]++;
            while (distinct > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    distinct--;
                }
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}