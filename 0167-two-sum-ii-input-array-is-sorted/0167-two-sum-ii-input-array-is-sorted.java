class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length -1;
        int sum = numbers[left] + numbers[right];
        int[] res = {0, 0};
        while(left < right) {
            if(sum < target) {
                sum -= numbers[left];
                left++;
                sum += numbers[left];
            }
            else if (sum > target) {
                sum -= numbers[right];
                right--;
                sum += numbers[right];
            }
            else {
                res[0] = left+1;
                res[1] = right+1;
                break;
            }
        }
        return res;
    }
}