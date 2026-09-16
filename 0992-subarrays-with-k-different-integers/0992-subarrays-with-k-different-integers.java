class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int a = solver(nums, k);
        int b = solver(nums, k - 1);
        return a - b;
    }

    private int solver(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}