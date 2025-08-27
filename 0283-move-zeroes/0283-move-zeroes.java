class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while(left < nums.length && right < nums.length){
            if(nums[left]!=0) {
                left++;
                continue;
            }
            if(nums[right] == 0 || right < left) {
                right++;
                continue;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}