class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int[] pfx = new int[n];
        pfx[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pfx[i] = pfx[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            if (map.containsKey(pfx[i] - goal)) {
                ans += map.get(pfx[i] - goal);
            }
            map.put(pfx[i], map.getOrDefault(pfx[i], 0) + 1);
        }
        return ans;
    }
}