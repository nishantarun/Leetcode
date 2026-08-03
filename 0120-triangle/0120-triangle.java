class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] prev = new int[n];
        prev[0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i);
            int[] curr = new int[n];
            for (int j = 0; j < list.size(); j++) {
                int min = list.get(j);
                int up = Integer.MAX_VALUE;
                if (j < i) {
                    up = prev[j];
                }
                int rightD = Integer.MAX_VALUE;
                if (j > 0) {
                    rightD = prev[j - 1];
                }
                min += Math.min(up, rightD);
                curr[j] = min;
            }
            prev = curr;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prev[i]);
        }
        return min;
    }
}