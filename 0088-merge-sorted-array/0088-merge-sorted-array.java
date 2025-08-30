class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = mergeIt(nums1, m, nums2, n);
        for(int i = 0; i< m+n; i++) {
            nums1[i] = ans[i];
        }
    }

    public int[] mergeIt(int[] nums1, int m, int[] nums2, int n){
        int[] res = new int[m+n];
        int i =0;
        int left = 0;
        int right = 0;
        while(left<m && right < n) {
            if(nums1[left] < nums2[right]){
                res[i] = nums1[left];
                left++;
                i++;
            } 
            else if(nums1[left] > nums2[right]){
                res[i] = nums2[right];
                i++;
                right++;
            }
            else {
                res[i] = nums1[left];
                i++;
                res[i] = nums2[right];
                i++;
                left++;
                right++;
            }
        }
        while(left < m) {
            res[i] = nums1[left];
            i++;
            left++;
        }
        while(right < n) {
            res[i] = nums2[right];
            i++;
            right++;
        }
        return res;
    }
}