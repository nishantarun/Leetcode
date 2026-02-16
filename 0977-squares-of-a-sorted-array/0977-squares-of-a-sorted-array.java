class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] res = new int[nums.length];
        int idx = 0;
        while(left<=right){
            if(Math.pow(nums[left], 2) > Math.pow(nums[right], 2)){
                res[idx] = (int)Math.pow(nums[left], 2);
                left++;
                idx++;
            }
            else {
                res[idx] = (int)Math.pow(nums[right], 2);
                right--;
                idx++;
            }
        }
        int l = 0;
        int r = res.length-1;
        while(l<r) {
            int temp = res[l];
            res[l] = res[r];
            res[r] = temp;
            l++;
            r--;
        }
        return res;
    }
}