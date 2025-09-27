class Solution {
    public boolean search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    public boolean helper(int[] nums, int target, int start, int end) {
        if (start > end) {
            return false;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return true;
        }
        if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
            return helper(nums, target, start + 1, end - 1);
        }
        if (nums[start] <= nums[mid]) {
            if (target >= nums[start] && target < nums[mid]) {
                return helper(nums, target, start, mid - 1);
            } else {
                return helper(nums, target, mid + 1, end);
            }
        } else {
            if (target > nums[mid] && target <= nums[end]) {
                return helper(nums, target, mid + 1, end);
            } else {
                return helper(nums, target, start, mid - 1);
            }
        }
    }
}