class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= k - 1)
                list.add(nums[dq.peekFirst()]);
        }

        int ansLength = list.size();
        int[] ans = new int[ansLength];
        for (int i = 0; i < ansLength; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}