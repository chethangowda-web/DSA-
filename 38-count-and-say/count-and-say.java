class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for(int i = 2; i <= n; i++){
            StringBuilder next = new StringBuilder();
            int j = 0;
            while(j < result.length()){
                char digit = result.charAt(j);
                int count = 0;
                while(j < result.length() && result.charAt(j) == digit){
                    count++;
                    j++;
                }

                next.append(count);
                next.append(digit);
            }
            result = next.toString();
        }
        return result;
    }
}