class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        for(int i = 0; i< nums.length; i++) {
            freq[nums[i]] += 1;
        }
        int max = 0;
        for(int ele : freq) {
            max = Math.max(max, ele);
        }
        int count = 0;
        for(int i = 0; i< nums.length; i++) {
            if(freq[nums[i]] == max){
                count++;
            }
        }
        return count;
    }
}