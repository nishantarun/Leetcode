class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }

    public void reverse(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        while(left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}