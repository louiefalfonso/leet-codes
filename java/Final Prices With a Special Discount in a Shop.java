/*
 * Final Prices With a Special Discount in a Shop -1475
 */

 import java.util.ArrayDeque;
 import java.util.Deque;
 
 class Solution {
    public int[] finalPrices(int[] prices) {
        // Create a stack to keep track of the indices of prices that haven't found a
        // discount yet
        Deque<Integer> stack = new ArrayDeque<>();
        int n = prices.length;
        // Initialize an array to hold the final prices after applying the discounts
        int[] finalPrices = new int[n];

        // Iterate over the array of prices
        for (int i = 0; i < n; ++i) {
            // Store the original price as the final price for now
            finalPrices[i] = prices[i];

            // Check if the current price can be a discount for the price at the top of the
            // stack
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                // Apply discount to the top price and update it in the finalPrices array
                finalPrices[stack.pop()] -= prices[i];
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        // Return the array of final prices after applying the discounts where
        // applicable
        return finalPrices;
    }
}