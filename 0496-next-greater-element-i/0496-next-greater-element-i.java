class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums2.length];
        nextGreaterElement(nums2, nums2.length-1, stack, res);
        int[] ans = new int[nums1.length];
        int j = 0;
        for(int ele : nums1) {
            for(int i = 0; i< nums2.length; i++) {
                if(nums2[i] == ele) {
                    ans[j] = res[i];
                    j++;
                }
            }
        }
        return ans;
    }

    public void nextGreaterElement(int[] nums, int idx, Stack<Integer> stack, int[] res) {
        if (idx < 0) {
            return;
        }
        while (!stack.isEmpty() && nums[idx] >= stack.peek()) {
            stack.pop();
        }
        res[idx] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(nums[idx]);
        nextGreaterElement(nums, idx - 1, stack, res);
    }
}