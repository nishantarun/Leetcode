class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int prodpre = 1;
        int prodsuff = 1;
        int left = 0;
        int right = n - 1;
        while (left < n && right >= 0) {
            prodpre *= nums[left];
            prefix[left] = prodpre;
            left++;
            prodsuff *= nums[right];
            suffix[right] = prodsuff;
            right--;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[i] = suffix[i + 1];
            } else if (i == n - 1) {
                res[i] = prefix[n - 2];
            } else {

                res[i] = prefix[i - 1] * suffix[i + 1];
            }
        }
        return res;
    }
}