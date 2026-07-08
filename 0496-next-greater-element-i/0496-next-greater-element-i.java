class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] nextGreaterArr = nextGreaterHelper(nums2);
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], nextGreaterArr[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public int[] nextGreaterHelper(int[] arr) {
        int[] res = new int[arr.length];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!dq.isEmpty() && dq.peek() <= arr[i]) {
                dq.pop();
            }
            if (dq.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = dq.peek();
            }
            dq.push(arr[i]);
        }
        return res;
    }
}