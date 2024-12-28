/*
 * House Robber - 198
 */

 class Solution {
    public int rob(int[] nums) {
        // f represents the max profit we can get from the previous house
        int prevNoRob = 0;
        // g represents the max profit we can get if we rob the current house
        int prevRob = 0;

        // Iterate over all the houses in the array
        for (int currentHouseValue : nums) {
            // Store max profit of robbing/not robbing the previous house
            int tempPrevNoRob = Math.max(prevNoRob, prevRob);

            // If we rob the current house, we cannot rob the previous one
            // hence our current profit is previous house's no-rob profit + current house
            // value
            prevRob = prevNoRob + currentHouseValue;

            // Update the previous no-rob profit to be the best of robbing or not robbing
            // the last house
            prevNoRob = tempPrevNoRob;
        }

        // Return the max profit we can get from the last house,
        // regardless of whether we rob it or not
        return Math.max(prevNoRob, prevRob);
    }
}