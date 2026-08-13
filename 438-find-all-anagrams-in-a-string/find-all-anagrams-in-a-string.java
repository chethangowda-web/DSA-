class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length()){
            return result;
        }

        int[] Freq = new int[26];
        int[] windowFreq = new int[26];

        for(char c : p.toCharArray()){
            Freq[c - 'a']++;
        }

        int left = 0;
        for(int right = 0; right < s.length(); right++){
            windowFreq[s.charAt(right) - 'a']++;
        

        if(right - left + 1 > p.length()){
            windowFreq[s.charAt(left) - 'a']--;
            left++;
        }

        if(right - left + 1 == p.length() && Arrays.equals(Freq , windowFreq)){
            result.add(left);
        }
        }
        return result;
        
    }
}