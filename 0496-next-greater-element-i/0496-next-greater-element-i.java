class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        nextGreaterElement(nums2, nums2.length - 1, stack, map);
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public void nextGreaterElement(int[] nums, int idx, Stack<Integer> stack, HashMap<Integer, Integer> map) {
        if (idx < 0) {
            return;
        }
        while (!stack.isEmpty() && nums[idx] >= stack.peek()) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            map.put(nums[idx], -1);
        } else {
            map.put(nums[idx], stack.peek());
        }
        stack.push(nums[idx]);
        nextGreaterElement(nums, idx - 1, stack, map);
    }
}