class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        while (isFound(nums, original)) {
            original *= 2;
        }
        return original;
    }

    public boolean isFound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

}