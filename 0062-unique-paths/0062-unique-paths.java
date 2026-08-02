class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        prev[0] = 1;
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                temp[j] = prev[j];
                if (j > 0) {
                    temp[j] += temp[j - 1];
                }
            }
            prev = temp;
        }
        return prev[n - 1];
    }
}