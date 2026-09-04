class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        return leftCollision(asteroids);
    }

    public int[] leftCollision(int[] arr) {
        int n = arr.length;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            boolean alive = true;
            while (!stack.isEmpty() && num < 0 && stack.peek() > 0) {
                if (Math.abs(num) > stack.peek()) {
                    stack.pop();
                } else if (Math.abs(num) == stack.peek()) {
                    stack.pop();
                    alive = false;
                    break;
                } else {
                    alive = false;
                    break;
                }
            }
            if (alive) {
                stack.push(num);
            }
        }

        int size = stack.size();
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}