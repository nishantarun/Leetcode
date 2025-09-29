class Solution {
    public int firstMissingPositive(int[] nums) {
        int hash[] =new int[nums.length+1];
        for(int i:nums){
            if(i>=0 && i<=nums.length) hash[i]++;
        }
        for(int i=1;i<=nums.length;i++) if(hash[i]==0) return i;
        return nums.length+1;
    }
}