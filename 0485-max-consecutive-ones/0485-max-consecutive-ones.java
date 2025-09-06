class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null) return 0;
        int count = 0;
        int maxCount = count;
        for(int i =0;i<nums.length;i++) {
            if(nums[i] == 1){
                count++;
            }
            else {
                maxCount = Math.max(count,maxCount);
                count = 0;
            }
        }
        maxCount = Math.max(count,maxCount);
        return maxCount;
    }
}