class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                for (int j = i; j < i + k && j < s.length(); j++) {
                    sum += Character.getNumericValue(s.charAt(j));
                }
                result.append(sum);
            }
            s = result.toString();
           
        }
        return s;
    }
}