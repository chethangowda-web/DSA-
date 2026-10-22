class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m){
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(int i = 0; i < n; i++){
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        for(int i = n; i < m; i++){
            if(matches(count1 , count2)){
                return true;
            }

            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(i - n) - 'a']--;
        }

        return matches(count1 , count2);
    }

    private boolean matches(int[] count1 , int[]count2){
        for(int i = 0; i < 26; i++){
            if(count1[i] != count2[i]){
                return false;
            }
        }
        return true;
    }
}