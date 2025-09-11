class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0 , nums.length-1);
    }

    public int[] mergeSort(int[] nums, int start, int end) {
       if(start == end) {
        return new int[] {nums[start]};
       }
        int mid = start + (end - start) /2;
        int[] leftarr = mergeSort(nums, start, mid);
        int[] rightarr = mergeSort(nums,mid+1, end);
        return merge(leftarr, rightarr);
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int left = 0;
        int right = 0;
        int i = 0;
        while(left < arr1.length && right < arr2.length) {
            if(arr1[left] < arr2[right]) {
                res[i++] = arr1[left++];
            }
            else if(arr2[right] < arr1[left]){
                res[i++] = arr2[right++];
            }
            else {
                res[i++] = arr1[left++];
                res[i++] = arr2[right++];
            }
        }
        while(left < arr1.length) {
            res[i++] = arr1[left++];
        }
        while(right < arr2.length) {
            res[i++] = arr2[right++];
        }
        return res;
    }
}