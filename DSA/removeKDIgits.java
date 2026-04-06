class Solution {
    public String removeKdigits(String num, int k) {
       Stack<Character> st = new Stack<>();

       for(int i = 0; i < num.length(); i++){
        char digit = num.charAt(i); // string are converted to character and digit is a variable with current digit 

        while(!st.isEmpty() && k > 0 && st.peek() > digit){
            st.pop();
            k--;
        }

        st.push(digit);
       }

       while(k > 0){
        st.pop();
        k--;
       }

       if(st.isEmpty()) return "0";

       StringBuilder res = new StringBuilder();

       while(!st.isEmpty()){
        res.append(st.pop());
       }

       while(res.length() > 0 && res.charAt(res.length() - 1) == '0'){
        res.deleteCharAt(res.length() - 1);
       }

       res.reverse();

       if(res.length() == 0) return "0";

       return res.toString();
    }
}