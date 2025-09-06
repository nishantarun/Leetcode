class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int p = 0;
        int n = 0;
        int i = 0;
        while(p < nums.length && n < nums.length) {
            while(nums[p] < 0) {
                p++;
            }
            while(nums[n] > 0) {
                n++;
            }
            res[i++] = nums[p++];
            res[i++] = nums[n++];
        }
        return res;
    } 
}