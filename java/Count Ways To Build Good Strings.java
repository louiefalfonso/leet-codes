/*
 * Count Ways To Build Good Strings - 2466
 */

 import java.util.Arrays;

 class Solution {
    // Constant for the modulus to be used for result to prevent overflow
    private static final int MOD = (int) 1e9 + 7;

    // Cache for already computed results to avoid repeated calculations
    private int[] memoization;

    // Variables to store the lower and upper bounds of the string length
    private int lowerBound;
    private int upperBound;

    // Variables to store the value to be added when encountering a '0' or '1' in
    // the string
    private int valueZero;
    private int valueOne;

    public int countGoodStrings(int low, int high, int zero, int one) {
        // Initialize the cache array with a size of 'high + 1' and fill it with -1
        // indicating that no calculations have been made for any index
        memoization = new int[high + 1];
        Arrays.fill(memoization, -1);

        // Assign the provided bounds and values to the respective class fields
        lowerBound = low;
        upperBound = high;
        valueZero = zero;
        valueOne = one;

        // Begin depth-first search from the starting point '0'
        return dfs(0);
    }

    // Helper method that employs depth-first search to compute the good strings
    private int dfs(int index) {
        // If the current index is beyond the upper bound, return 0 as it cannot form a
        // valid string
        if (index > upperBound) {
            return 0;
        }
        // If a result for the current index has already been computed (memoized),
        // return it
        if (memoization[index] != -1) {
            return memoization[index];
        }

        // Initialize the answer for this index
        long ans = 0;

        // If the current index is within the bounds, count it as one valid string
        if (index >= lowerBound && index <= upperBound) {
            ans++;
        }

        // Use recurrence to count additional good strings by adding valueZero and
        // valueOne to index recursively
        ans += dfs(index + valueZero) + dfs(index + valueOne);

        // Take modulus to prevent overflow
        ans %= MOD;

        // Cache the computed result for the current index before returning
        memoization[index] = (int) ans;
        return memoization[index];
    }
}
