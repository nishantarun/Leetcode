class Solution {
    public List<Integer> majorityElement(int[] nums) {
        final int n = nums.length;
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        final List<Integer> res = new ArrayList<>(2);
        if (count1 > n / 3) res.add(candidate1);
        if (count2 > n / 3) res.add(candidate2);

        return res;
    }
}
