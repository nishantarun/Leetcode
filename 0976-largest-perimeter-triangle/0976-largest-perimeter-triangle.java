class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length-1; i>1; i--) {
            int third = i;
            int second = i-1;
            int first = i-2;
            if(nums[first] + nums[second] > nums[third]) {
                return nums[first] + nums[second] + nums[third];
            }
        }
        return 0;
    }
}