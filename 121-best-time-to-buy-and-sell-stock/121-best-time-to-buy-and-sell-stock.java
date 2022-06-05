class Solution {
    public int maxProfit(int[] prices) {
        int minL = prices[0];
        int profit = 0;
        for(int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, Math.max(prices[i] - minL, 0));
            minL = Math.min(minL, prices[i]);
        }
        return profit;
    }
}