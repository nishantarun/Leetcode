class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for(int i = nums.length-2; i >=0; i--){
            if(nums[i] < nums[i+1]) {
                pivot = i;
                break;
            }
        }
        if(pivot == -1) {
            reverse(nums,0, nums.length-1);
            return;
        }
        for(int i = nums.length-1; i>=0;i--) {
            if(nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }
        reverse(nums, pivot+1, nums.length-1);
        
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void reverse(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        while(left <= right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
}