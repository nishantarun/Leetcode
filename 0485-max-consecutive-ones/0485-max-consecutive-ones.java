class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null) return 0;
        int count = 0;
        int maxCount = count;
        for(int i =0; i<nums.length;i++) {
            if(nums[i] == 1){
                count++;
            }
            else {
                if(count > maxCount) {
                    maxCount = count;
                }
                count = 0;
            }
        }
        return maxCount < count ? count : maxCount;
    }
}