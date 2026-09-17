class Solution {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (map.containsKey(sum)) {
                return true;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return false;
    }
}