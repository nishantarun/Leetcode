class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int ele : nums){
            max = Math.max(ele, max);
        }
        int start = 1;
        int end = max;
        while(start < end){
            int mid = start + (end - start) / 2;
            int sum = divideSum(nums, mid);
            if(sum <= threshold){
                end = mid;
            }
            else {
                start = mid +1;
            }
        }
        return end;
    }

    public int divideSum(int[] nums, int d){
        int sum = 0;
        for(int ele : nums){
            sum += (int)Math.ceil((double)ele/d);
        }
        return sum;
    }
}