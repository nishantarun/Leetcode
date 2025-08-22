class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int a = 0;
        int b = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(b < nums.length) {
            if(sum < target) {
                sum += nums[b];
                b++;
            }
            while (sum >= target) {
            min = Math.min(min, b - a);
            sum -= nums[a];
            a++;
        }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}