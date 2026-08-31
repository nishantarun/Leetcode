class Solution {
    public int trap(int[] heights) {
        int n = heights.length;

        int[] lGreatest = leftGreatest(heights);
        int[] rGreatest = rightGreatest(heights);

        int totalWater = 0;

        for (int i = 0; i < n; i++) {
            int lg = lGreatest[i];
            int rg = rGreatest[i];
            int lblock = 0;
            int rblock = 0;

            if (lg != -1)
                lblock = heights[lg];
            if (rg != -1)
                rblock = heights[rg];

            int water = Math.min(lblock, rblock) - heights[i];
            if (water > 0)
                totalWater += water;
        }

        return totalWater;
    }

    public int[] leftGreatest(int[] heights) {
        int n = heights.length;

        int[] res = new int[n];
        res[0] = -1;

        int max = 0;
        for (int i = 1; i < n; i++) {
            res[i] = max;
            if (heights[i] >= heights[max]) {
                max = i;
            }
        }

        return res;
    }

    public int[] rightGreatest(int[] heights) {
        int n = heights.length;

        int[] res = new int[n];
        res[n - 1] = -1;

        int max = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            res[i] = max;
            if (heights[i] >= heights[max]) {
                max = i;
            }
        }

        return res;
    }
}