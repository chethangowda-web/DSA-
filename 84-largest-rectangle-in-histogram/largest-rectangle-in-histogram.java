class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i <= heights.length; i++){
            int currentHeight = (i == heights.length) ?  0 : heights[i];

            while(!st.isEmpty() && currentHeight < heights[st.peek()]){
                int height = heights[st.pop()];
                int leftBoundry = st.isEmpty() ? -1 : st.peek();

                int width = i - leftBoundry - 1;
                int area = height * width;
                maxArea = Math.max(maxArea , area);
           }

        if(i < heights.length){
            st.push(i);
        }
        }
        return maxArea;
    }
}