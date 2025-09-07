class Solution {
    public boolean check(int[] nums) {
        int drop = 0;
        int dropcount = 0;
        for(int i =0; i< nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                drop = i;
                dropcount++;
                break;
            }
        }
        if(dropcount == 0){
            return true;
        }
        
        int[] rotatedBackArray = rotateBack(nums, drop);
        Arrays.sort(nums);
        int[] sortedArray = nums;
        for(int i =0; i<nums.length; i++){
            if(rotatedBackArray[i] != sortedArray[i]){
                return false;
            }
        }
        return true;
    }

    public int[] rotateBack(int[] nums, int drop){
        int[] arr = new int[nums.length];
        int k = 0;
        for(int i = drop+1; i<arr.length; i++){
            arr[k] = nums[i];
            k++;
        }
        for(int i =0; i<drop+1;i++){
            arr[k] = nums[i];
            k++;
        }
        return arr;
    }
}