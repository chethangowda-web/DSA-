class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i = 0; i <= n; i++){
            int currHeight = (i == n) ? 0 : heights[i];
            while(!st.isEmpty() && currHeight < heights[st.peek()]){
                int height = heights[st.pop()];
                int width;

                if(st.isEmpty()){
                    width = i;
                }else{
                    width = i - st.peek() - 1;
                }

                int area = height * width;

                maxArea = Math.max(maxArea , area);
            }
            st.push(i);
        }
        return maxArea;
    }
}