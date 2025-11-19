class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int ele : nums)
            set.add(ele);
        while (set.contains(original)) {
            original *= 2;
        }
        return original;
    }
}