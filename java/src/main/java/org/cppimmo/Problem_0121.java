class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int currentProfit = prices[i] - minPrice; // Future price - lowest price
            maxProfit = Math.max(maxProfit, currentProfit);
            minPrice = Math.min(prices[i], minPrice);
        }
        return maxProfit;
    }
}
