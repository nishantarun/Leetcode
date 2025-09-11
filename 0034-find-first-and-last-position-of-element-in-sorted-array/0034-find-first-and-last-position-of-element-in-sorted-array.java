class Solution {
    public int[] searchRange(int[] nums, int target) {
        int idx = helper(nums, target, 0, nums.length - 1);
        if (idx == -1) {
            return new int[] { -1, -1 };
        }
        int left = idx;
        int right = idx;
        while (left - 1 >= 0 && nums[left - 1] == target) {
            left--;
        }
        while (right + 1 < nums.length && nums[right + 1] == target) {
            right++;
        }
        return new int[] { left, right };
    }

    public int helper(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return helper(nums, target, mid + 1, end);
        } else {
            return helper(nums, target, start, mid - 1);
        }
    }
}