class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int left = 0, right = people.length - 1;
        while (left <= right) {
            int weight = people[left] + people[right];
            if (weight <= limit) {
                left++;
            }
            boats++;
            right--;
        }
        return boats;
    }
}