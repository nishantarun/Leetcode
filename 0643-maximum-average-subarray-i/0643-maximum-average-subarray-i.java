class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int a = 0;
        int b = k-1;
        double currSum = 0;
        double maxSum = 0;
        for(int i = a; i <= b; i++) {
            currSum += nums[i];
        }
        maxSum = currSum;
        while(b < nums.length-1) {
            b++;
            currSum = currSum - nums[a] + nums[b];
            a++;
            if(currSum > maxSum) {
                maxSum = currSum;
            }
        }
        return maxSum/k;
    }
}