class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    public int helper(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[start] <= nums[mid]) {
            if (target < nums[mid] && target >= nums[start]) {
                return helper(nums, target, start, mid - 1);
            } else {
                return helper(nums, target, mid + 1, end);
            }
        } else {
            if (target <= nums[end] && target > nums[mid]) {
                return helper(nums, target, mid + 1, end);
            } else {
                return helper(nums, target, start, mid - 1);
            }
        }
    }
}