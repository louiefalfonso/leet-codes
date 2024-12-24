/*
 * Min Cost Climbing Stairs - 746
 */


class Solution {
    // Declare a private instance variable to store the memoized results
    private Integer[] f;
    // Declare a private instance variable to store the cost array
    private int[] cost;

    // Method to calculate the minimum cost to climb the stairs
    public int minCostClimbingStairs(int[] cost) {
        // Store the cost array in the instance variable
        this.cost = cost;
        // Initialize the memoization array with null values
        f = new Integer[cost.length];
        // Return the minimum cost to climb the stairs from either the first or second step
        return Math.min(dfs(0), dfs(1));
    }

    // Method to perform DFS from a given step
    private int dfs(int i) {
        // Base case: if we have reached the end of the stairs, return 0
        if (i >= cost.length) {
            return 0;
        }
        // If the result for the current step is not memoized, calculate it
        if (f[i] == null) {
            // Calculate the minimum cost to climb the stairs from the current step
            // by considering the cost of the current step and the minimum cost to climb
            // from the next step or the step after that
            f[i] = cost[i] + Math.min(dfs(i + 1), dfs(i + 2));
        }
        // Return the memoized result for the current step
        return f[i];
    }
}