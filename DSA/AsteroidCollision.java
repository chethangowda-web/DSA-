
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
       
        int n = asteroids.length;
    
        List<Integer> st = new ArrayList<>();

    
        for (int i = 0; i < n; i++) {
            if (asteroids[i] > 0) {
                st.add(asteroids[i]);
            }
            else {

                while (!st.isEmpty() && st.get(st.size() - 1) > 0 &&
                       st.get(st.size() - 1) < Math.abs(asteroids[i])) {
                    st.remove(st.size() - 1);
                }

                if (!st.isEmpty() && st.get(st.size() - 1) == Math.abs(asteroids[i])) {
                    st.remove(st.size() - 1);
                }
                else if (st.isEmpty() || st.get(st.size() - 1) < 0) {
                    st.add(asteroids[i]);
                }
            }
        }
        int[] result = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            result[i] = st.get(i);
        }
        return result;
    }
}
