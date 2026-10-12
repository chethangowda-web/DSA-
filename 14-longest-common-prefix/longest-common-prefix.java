class Solution {
    public String longestCommonPrefix(String[] strs) {
        // take a variable and assign starting member to it

        String prefix = strs[0]; // f-l then loop will break it return fl as output

        for(int i = 1; i < strs.length; i++){
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0 , prefix.length() - 1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
}