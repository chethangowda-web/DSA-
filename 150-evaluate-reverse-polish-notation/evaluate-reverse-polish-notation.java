class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int right = stack.pop();
                int left = stack.pop();
                int result = 0;

                if(token.equals("+")){
                    result = left + right;
                }else if(token.equals("-")){
                    result = left - right;
                }else if(token.equals("*")){
                    result = left * right;
                }else{
                    result = left / right;
                }
                stack.push(result);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}