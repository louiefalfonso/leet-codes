/*
 * Coin Change - 322
 */

 import java.util.Arrays;
 
 class Solution {
    public int coinChange(int[] coins, int amount) {
        // Define a large value which would act as our "infinity" substitute.
        final int INF = 1 << 30;

        // 'dp' will hold our optimal solutions to sub-problems, dp[i] will store the
        // minimum number of coins needed to make amount 'i'.
        int[] dp = new int[amount + 1];

        // Initialize the dp array with INF to signify that those amounts are currently
        // not achievable with the given coins.
        Arrays.fill(dp, INF);

        // Base case initialization: No coins are needed to make an amount of 0.
        dp[0] = 0;

        // Iterate over each type of coin available.
        for (int coin : coins) {
            // For each coin, try to build up to the target amount, starting from the coin's
            // value itself up to 'amount'.
            for (int currentAmount = coin; currentAmount <= amount; ++currentAmount) {
                // Check if the current coin can contribute to a solution for 'currentAmount'.
                // If so, update dp[currentAmount] to the minimum value between its current and
                // the new possible number of coins used.
                dp[currentAmount] = Math.min(dp[currentAmount], dp[currentAmount - coin] + 1);
            }
        }

        // Return the answer for the target 'amount'. If dp[amount] is still INF, then
        // it was not possible to make the amount using the given coins.
        return dp[amount] >= INF ? -1 : dp[amount];
    }
}