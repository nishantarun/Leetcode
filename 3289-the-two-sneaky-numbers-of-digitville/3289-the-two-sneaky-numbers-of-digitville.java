class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res = new int[2];
        int[] visited = new int[nums.length-1];
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(visited[nums[i]] == 1) {
                res[j] = nums[i];
                j++;
            }
            visited[nums[i]] = 1;
        }
        return res;
    }
}