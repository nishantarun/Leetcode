class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = merge(nums1, nums2);
        if((m+n) %2 == 0) {
            return ((double)res[(m+n)/2 -1] + res[(m+n)/2]) / 2;
        }
        else {
            return (double)res[(m+n)/2];
        }
    }
    public static int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int i = 0;
        int left = 0;
        int right = 0;
        while (left < arr1.length && right < arr2.length) {
            int leftEle = arr1[left];
            int rightEle = arr2[right];
            if (leftEle < rightEle) {
                res[i++] = leftEle;
                left++;
            } else {
                res[i++] = rightEle;
                right++;
            }
        }
        while (left < arr1.length) {
            res[i++] = arr1[left++];
        }
        while (right < arr2.length) {
            res[i++] = arr2[right++];
        }
        return res;
    }
}