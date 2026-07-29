class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] map = new int[max + 1];
        for (int num : nums) {
            map[num] += num;
        }
        int prev = map[0];
        int prev2 = 0;
        for (int i = 1; i < map.length; i++) {
            int take = map[i];
            if (i > 1)
                take += prev2;
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}