class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        if (tokens.length == 0 || power < tokens[0]) return 0;
        int maxScore = 0;
        int score = 0;
        int l = 0, r = tokens.length - 1;
        while (l <= r) {
            if (power >= tokens[l]) {
                score++;
                power -= tokens[l];
                maxScore = Math.max(score, maxScore);
                l++;
            } else {
                score--;
                power += tokens[r];
                r--;
            }
        }
        return maxScore;
    }
}