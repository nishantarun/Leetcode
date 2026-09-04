class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] prevSmaller = prevSmaller(nums);
        int[] nextSmaller = nextSmaller(nums);
        int[] prevGreater = prevGreater(nums);
        int[] nextGreater = nextGreater(nums);

        long sumMins = 0;
        long sumMaxs = 0;

        for (int i = 0; i < n; i++) {
            sumMins += (long) (i - prevSmaller[i]) * (nextSmaller[i] - i) * nums[i];
            sumMaxs += (long) (i - prevGreater[i]) * (nextGreater[i] - i) * nums[i];
        }

        long totalSum = sumMaxs - sumMins;

        return totalSum;
    }

    public int[] prevSmaller(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }

        return res;
    }

    public int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = n;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }

        return res;
    }

    public int[] prevGreater(int[] arr) {
        int n = arr.length;

        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }

        return res;
    }

    public int[] nextGreater(int[] arr) {
        int n = arr.length;

        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = n;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }

        return res;
    }
}