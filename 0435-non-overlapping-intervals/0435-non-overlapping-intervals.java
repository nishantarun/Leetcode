class Solution {
    public int eraseOverlapIntervals(int[][] intervals) { 
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 0;
        int finish = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] >= finish) {
                res++;
                finish = interval[1];
            }
        }
        return intervals.length - res;
    }
}