class Solution {
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;

        for (int right = 0; right < fruits.length; right++) {

            // Add current fruit
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // Shrink until at most 2 distinct fruits remain
            while (map.size() > 2) {

                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }

            // Update maximum basket size
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}