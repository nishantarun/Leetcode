class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] prevSmaller = prevSmaller(arr);
        int[] nextSmaller = nextSmaller(arr);

        long sum = 0;
        long mod = (long) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            long curr = (long) (i - prevSmaller[i]) * (nextSmaller[i] - i) * arr[i];
            sum = (sum + curr) % mod;
        }

        return (int) sum;
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
}