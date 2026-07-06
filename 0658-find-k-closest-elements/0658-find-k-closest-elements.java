class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (r - l + 1 > k) {
            if (Math.abs(x - arr[l]) > Math.abs(x - arr[r])) {
                l++;
            } else {
                r--;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
