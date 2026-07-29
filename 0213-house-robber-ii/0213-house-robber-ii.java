class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = robLinear(nums, 0, nums.length - 2);
        int right = robLinear(nums, 1, nums.length - 1);
        return Math.max(left, right);
    }

    public int robLinear(int[] nums, int start, int end) {
        int prev = nums[start];
        int prev2 = 0;
        for(int i = start + 1; i <= end; i++) {
            int take = nums[i];
            if(i > 1) take += prev2;
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}