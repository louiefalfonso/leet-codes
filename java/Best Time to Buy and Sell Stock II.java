// Best Time to Buy and Sell Stock II - 122

class Solution {

    public int maxProfit(int[] prices) {
        int totalProfit = 0; // Initialize total profit to zero

        // Loop through the array of prices
        for (int i = 1; i < prices.length; ++i) {
            // Calculate the profit for the current day by subtracting the previous day's
            // price from the current day's price
            int dailyProfit = Math.max(0, prices[i] - prices[i - 1]);

            // Add the daily profit to the total profit
            // This will accumulate if buying on the i-1 day and selling on the i day is
            // profitable
            totalProfit += dailyProfit;
        }

        // Return the total profit accumulated
        return totalProfit;
    }
}