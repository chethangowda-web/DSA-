class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String current = "";
        int number = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } 
            else if (ch == '[') {
                numStack.push(number);
                stringStack.push(current);
                number = 0;
                current = "";
            } 
            else if (ch == ']') {
                int repeat = numStack.pop();
                String previous = stringStack.pop();
                StringBuilder temp = new StringBuilder(previous);
                for (int i = 0; i < repeat; i++) {
                    temp.append(current);
                }
                current = temp.toString();
            } 
            else {
                current += ch;
            }
        }
        return current;
    }
}