class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        int i = 0, left = 0, right = 0;

        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                merged[i++] = nums1[left++];
            } else {
                merged[i++] = nums2[right++];
            }
        }
        while (left < m) {
            merged[i++] = nums1[left++];
        }
        while (right < n) {
            merged[i++] = nums2[right++];
        }

        for (int j = 0; j < m + n; j++) {
            nums1[j] = merged[j];
        }
    }
}
