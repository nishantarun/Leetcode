class Solution {
    public int totalFruit(int[] fruits) {
        int baskets = 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFruits = 0;
        int left = 0;
        for (int right = 0; right < fruits.length; right++) {
            int fruit = fruits[right];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
            while (map.size() > baskets) {
                map.put(fruits[left], map.getOrDefault(fruits[left], 0) - 1);
                if (map.get(fruits[left]) <= 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            int currFruits = right - left + 1;
            maxFruits = Math.max(currFruits, maxFruits);
        }
        return maxFruits;
    }
}