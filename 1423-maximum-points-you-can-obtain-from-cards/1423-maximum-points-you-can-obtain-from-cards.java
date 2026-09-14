class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lSum = 0;
        int rSum = 0;
        for (int i = n - 1; i >= n - k; i--) {
            rSum += cardPoints[i];
        }
        int maxPoints = rSum;
        for (int i = 0; i < k; i++) {
            lSum += cardPoints[i];
            rSum -= cardPoints[n - k + i];
            int points = lSum + rSum;
            maxPoints = Math.max(maxPoints, points);
        }
        return maxPoints;
    }
}