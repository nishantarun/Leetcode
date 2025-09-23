class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        // Binary search to find the position where missing count is >= k
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missing = arr[mid] - (mid + 1);  // Missing numbers before arr[mid]

            if (missing < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Left is the insertion point where missing numbers passed k
        // The k-th missing number is k + left because before index left,
        // there are 'left' numbers present, so k is offset by 'left'.
        return k + left;
    }
}
