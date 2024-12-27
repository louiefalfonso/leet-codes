/*
 * Best Time to Buy and Sell Stock with Transaction Fee - 714
 */

 class Solution {
    public int maxProfit(int[] prices, int fee) {
        // Initialize cash (f0) to represent max profit with 0 stocks on hand
        // Initialize hold (f1) to represent max profit with 1 stock on hand - bought on
        // the first day
        int cash = 0, hold = -prices[0];

        for (int i = 1; i < prices.length; ++i) {
            // Calculate the new cash by selling the stock held today, if it's a better
            // option than holding cash
            int newCash = Math.max(cash, hold + prices[i] - fee);
            // Calculate the new hold by buying the stock today, if it's a better option
            // than holding the current stock
            hold = Math.max(hold, cash - prices[i]);

            // Update cash to the newly calculated max profit with 0 stocks
            cash = newCash;
        }

        // Finally, return the cash, which represents the maximum profit with 0 stocks
        // on hand after all transactions
        return cash;
    }
}