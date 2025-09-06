class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null) return 0;
        int count = 0;
        int maxCount = count;
        for(int ele : nums) {
            if(ele == 1){
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