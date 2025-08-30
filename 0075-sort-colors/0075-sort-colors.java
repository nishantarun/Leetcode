class Solution {
    public void sortColors(int[] nums) {
        int[] temp = mergeSort(nums, 0, nums.length - 1);
        for(int i = 0; i<nums.length;i++) {
            nums[i] = temp[i];
        }
    }

    public static int[] mergeSort(int[] arr, int low, int high) {
        if (high == low) {
            return new int[] { arr[low] };
        }
        int mid = (low + high) / 2;
        int[] left = mergeSort(arr, low, mid);
        int[] right = mergeSort(arr, mid + 1, high);

        return merge(left, right);
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