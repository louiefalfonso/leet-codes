/*
 * Counting Bits - 338
 */

 class Solution {
    public int[] countBits(int n) {
        // Create an array 'bitCounts' of size n+1 to hold the number of 1s for each
        // number from 0 to n.
        int[] bitCounts = new int[n + 1];

        // Iterate over each number from 1 to n to calculate bit count.
        for (int i = 1; i <= n; ++i) {
            // Use the previously computed results to find the current number's bit count.
            // 'i & (i - 1)' drops the lowest set bit of i. So 'bitCounts[i & (i - 1)]'
            // gives us
            // the count of bits for the current number without the lowest set bit.
            // Then, we add 1 for the dropped bit to get the final count for the current
            // number.
            bitCounts[i] = bitCounts[i & (i - 1)] + 1;
        }

        // Return the populated array containing bit counts for all numbers from 0 to n.
        return bitCounts;
    }
}