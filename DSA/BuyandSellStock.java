class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices){
            minprice = Math.min(minprice , price);
            int profit = price - minprice;


            maxProfit = Math.max(maxProfit , profit);
        }
        return maxProfit;
    }
}