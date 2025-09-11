class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = 1;
        while(right < nums.length && left < nums.length){
            if(nums[left]%2 == 0) {
                left++;
            }
            if(nums[right]%2==0 && nums[left]%2!=0) {
                swap(nums, left, right);
                left++;
                right++;
            }
            else {
                right++;
            }
        }
        return nums;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}