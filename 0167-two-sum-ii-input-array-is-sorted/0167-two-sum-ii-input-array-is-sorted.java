class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;
        int sum = nums[left] + nums[right];
        while (left < right) {
            if (sum > target) {
                sum -= nums[right];
                right--;
                sum += nums[right];
            } else if (sum < target) {
                sum -= nums[left];
                left++;
                sum += nums[left];
            } else {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }
        return res;
    }
}