class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
        while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){ 
            int prevIndex = st.pop();
            ans[prevIndex] = i - prevIndex;
    }
            st.push(i);
        }
        return ans;
    }
}



// initailly maintain the stack 
// here we are dealing with the index values of the temperatures
// at last return the array of days that we waited to get the warmer temperature 
// mistake -> i need to iterate through the loop before checking the condition