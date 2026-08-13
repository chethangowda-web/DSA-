class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int [] windowFreq = new int[26];
        int [] patternFreq = new int[26];

        for(char c : s1.toCharArray()){
            patternFreq[c - 'a']++;
        }

        int left = 0;
        for(int right = 0; right < s2.length(); right++){
            windowFreq[s2.charAt(right) - 'a']++;

        if(right - left + 1 > s1.length()){
            windowFreq[s2.charAt(left) - 'a']--;

            left++;
        }

        if(right - left + 1 == s1.length() && Arrays.equals(windowFreq,  patternFreq)){
            return true;
        }
        }
        
        return false;
     }
}