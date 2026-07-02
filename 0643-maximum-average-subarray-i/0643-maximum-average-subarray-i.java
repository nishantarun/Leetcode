class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg = Integer.MIN_VALUE;
        double sum = 0;

        int left = 0;
        int right = 0;
        while (right < k) {
            sum += nums[right];
            right++;
        }
        avg = Math.max(avg, sum / k);
        while (right < nums.length) {
            sum = sum - nums[left] + nums[right];
            left++;
            right++;
            avg = Math.max(avg, sum / k);
        }
        return avg;
    }
}