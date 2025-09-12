class Solution {
    public int findPeakElement(int[] nums) {
        int peak = helper(nums, 0, nums.length-1);
        return peak;
    }

    public int helper(int[] nums, int start, int end) {
        int mid = start + (end - start) /2;
        if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])) {
            return mid;
        }
        if(nums[mid] < nums[mid+1]) {
            return helper(nums, mid+1, end);
        }
        else {
            return helper(nums, start, mid-1);
        }
    }
}