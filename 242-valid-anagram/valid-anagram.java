class Solution {
    public boolean isAnagram(String s, String t) {
        // first write the base condition so both the length should be same if not simply return false
        if(s.length() != t.length()){
            return false;
        }

        // take a new array of name count of size 26 beacuse the length of the alphabets
        int[] count = new int[26];

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
}