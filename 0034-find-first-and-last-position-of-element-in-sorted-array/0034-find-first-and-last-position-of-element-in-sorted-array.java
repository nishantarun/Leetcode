class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int left = helper(nums, target, true);
        int right = helper(nums, target, false);
        res[0] = left;
        res[1] = right;
        return res;
    }

    public int helper(int[] nums, int target, boolean isSearchingLeft) {
        int start = 0;
        int end = nums.length-1;
        int idx = -1;

        while(start <= end) {
            int mid = start + (end - start) /2;
            
            if(nums[mid] < target) {
                start = mid+1;
            }
            else if(nums[mid] > target) {
                end = mid-1;
            }
            else {
                idx = mid;
                if(isSearchingLeft) {
                    end = mid -1;
                }
                else {
                    start = mid +1;
                }
            }
        }
        return idx;
    }
}