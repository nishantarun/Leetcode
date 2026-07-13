class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int nextPositive = 0;
        int nextNegative = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                while (nums[nextPositive] < 0) {
                    nextPositive++;
                }
                res[i] = nums[nextPositive];
                nextPositive++;
            } else {
                while (nums[nextNegative] > 0) {
                    nextNegative++;
                }
                res[i] = nums[nextNegative];
                nextNegative++;
            }
        }
        return res;
    }
}