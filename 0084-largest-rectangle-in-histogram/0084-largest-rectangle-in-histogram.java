class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nextSmaller = nextSmaller(heights);
        int[] prevSmaller = prevSmaller(heights);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public int[] nextSmaller(int[] heights) {
        int[] res = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = heights.length;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    public int[] prevSmaller(int[] heights) {
        int[] res = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < res.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
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
}
