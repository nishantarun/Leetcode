class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        nextGreaterElement2(nums, nums.length - 1, 0, stack, res);
        return res;
    }

    public void nextGreaterElement2(int[] nums, int idx, int count, Stack<Integer> stack, int[] res) {
        if (idx == -1) {
            idx = nums.length - 1;
        }
        if (count == 2 * nums.length)
            return;

        
            while (!stack.isEmpty() && nums[idx] >= stack.peek()) {
                stack.pop();
            }
            res[idx] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[idx]);
        
        nextGreaterElement2(nums, idx - 1, count + 1, stack, res);
    }
}