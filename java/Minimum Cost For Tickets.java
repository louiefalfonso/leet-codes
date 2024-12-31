/*
 * Minimum Cost For Tickets - 983
 */

 import java.util.Arrays;
 
 class Solution {

    // Define constants for pass durations
    private static final int[] PASS_DURATIONS = new int[] { 1, 7, 30 };

    // Variables to store costs, days, and memoized values
    private int[] passCosts;
    private int[] travelDays;
    private int[] memo;
    private int totalDays;

    // Method to calculate the minimum cost of tickets for given travel days and
    // ticket costs
    public int mincostTickets(int[] days, int[] costs) {
        totalDays = days.length;
        memo = new int[totalDays];
        this.passCosts = costs;
        this.travelDays = days;

        // Fill memo array with default values to denote not calculated
        Arrays.fill(memo, -1);

        // Start DFS from the first day
        return dfs(0);
    }

    // Helper method to perform Depth-First Search (DFS)
    private int dfs(int currentIndex) {
        // Base case: if the currentIndex is beyond the last day, no cost is needed
        if (currentIndex >= totalDays) {
            return 0;
        }

        // If the cost has already been computed, return it
        if (memo[currentIndex] != -1) {
            return memo[currentIndex];
        }

        // Initialize result as the maximum value
        int result = Integer.MAX_VALUE;

        // Consider all types of passes
        for (int k = 0; k < 3; ++k) {
            // Find the index of the next day right after the pass expires
            int nextIndex = lowerBound(travelDays, travelDays[currentIndex] + PASS_DURATIONS[k]);

            // Calculate the minimum cost using the chosen pass
            result = Math.min(result, passCosts[k] + dfs(nextIndex));
        }

        // Save result to memo array
        memo[currentIndex] = result;

        // Return the final minimized cost
        return result;
    }

    // Helper method to find the lower bound index for a given day (binary search)
    private int lowerBound(int[] days, int targetDay) {
        int left = 0, right = days.length;
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid is less than target, ignore the left half
            if (days[mid] < targetDay) {
                left = mid + 1;
            } else {
                // If mid is greater or equal to target, ignore the right half
                right = mid;
            }
        }
        // Return the lower bound index
        return left;
    }
}
