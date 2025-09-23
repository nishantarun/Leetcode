class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missingCount = 0;
        int num = 1;
        while(missingCount <= k){
            if(!isFound(arr, num)){
                missingCount++;
                if(missingCount == k){
                    return num;
                }
            }
            num++;
        }
        return num;
    }

    public boolean isFound(int[] arr, int num){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == num) {
                return true;
            }
            else if (arr[mid] < num) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}