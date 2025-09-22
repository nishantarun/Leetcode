class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char res = helper(letters, target, 0, letters.length-1);
        return res;
    }

    public char helper(char[] letters, char target, int start, int end) {
        if(start > end) {
            if(start != letters.length){
                return letters[start];
            }
            else {
                return letters[0];
            }
        }
        int mid = start + (end - start) / 2;
        if(letters[mid] <= target) {
            return helper(letters, target, mid + 1, end);
        }
        else {
            return helper(letters, target, start, mid - 1);
        }
    }
}