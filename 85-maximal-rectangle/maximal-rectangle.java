class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(matrix[row][col] == '1'){
                    heights[col]++;
                }else{
                    heights[col] = 0;
                }
            }
            maxArea = Math.max(maxArea , largestRectangleArea(heights));
        }
            return maxArea;
        }

        private int largestRectangleArea(int[] heights){
            Stack<Integer> st = new Stack<>();
            int maxArea = 0;
            for(int i = 0; i <= heights.length; i++){
                int currentHeight = (i == heights.length) ? 0 : heights[i];

            while(!st.isEmpty() && currentHeight < heights[st.peek()]){
                int height = heights[st.pop()];
                int leftBoundary = st.empty() ? -1 : st.peek();
                int width = i - leftBoundary - 1;
                int area = height * width ;
                maxArea = Math.max(maxArea , area);
            }

            if(i < heights.length){
                st.push(i);
            }
        }
        return maxArea;
    }
}