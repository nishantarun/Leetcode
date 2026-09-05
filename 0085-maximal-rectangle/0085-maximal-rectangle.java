class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] pfx = new int[m][n];
        for (int j = 0; j < n; j++) {
            pfx[0][j] = matrix[0][j] - '0';
        }

        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                if (matrix[i][j] != '0') {
                    pfx[i][j] = pfx[i - 1][j] + matrix[i][j] - '0';
                } else {
                    pfx[i][j] = 0;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, largestRectangle(pfx[i]));
        }

        return max;
    }

    public int largestRectangle(int[] arr) {
        int n = arr.length;

        int[] prevSmaller = prevSmaller(arr);
        int[] nextSmaller = nextSmaller(arr);

        int max = 0;

        for (int i = 0; i < n; i++) {
            int area = (nextSmaller[i] - prevSmaller[i] - 1) * arr[i];
            max = Math.max(max, area);
        }

        return max;
    }

    public int[] prevSmaller(int[] arr) {
        int n = arr.length;

        int[] res = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
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