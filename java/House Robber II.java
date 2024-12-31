/*
 * House Robber II - 213
 */

 class Solution {
    // The main function to compute the maximum amount of money that can be robbed.
    public int rob(int[] nums) {
        int houseCount = nums.length;

        // If there's only one house, the maximum money is what's in that house.
        if (houseCount == 1) {
            return nums[0];
        }

        // Otherwise, find the maximum of two scenarios: excluding the first house or
        // excluding the last house.
        return Math.max(robMaxMoney(nums, 0, houseCount - 2), robMaxMoney(nums, 1, houseCount - 1));
    }

    // Helper function to calculate the max money that can be robbed in a specific
    // range of houses.
    private int robMaxMoney(int[] nums, int left, int right) {
        // Initialize two variables to keep track of the two previous maximum values.
        int inclPrev = 0; // This will hold the maximum amount including the previous house.
        int exclPrev = 0; // This will hold the maximum amount excluding the previous house.

        // Iterate through the range of houses.
        for (int i = left; i <= right; ++i) {
            // Calculate the new maximum including the current house.
            int inclCurr = exclPrev + nums[i];

            // Calculate the new maximum excluding the current house by taking the maximum
            // between inclPrev and exclPrev.
            exclPrev = Math.max(inclPrev, exclPrev);

            // Update inclPrev to be used in the next iteration.
            inclPrev = inclCurr;
        }

        // Return the maximum money that can be robbed within the specified range.
        // Must consider the final value of inclPrev and exclPrev, since one of them
        // will have the maximum.
        return Math.max(inclPrev, exclPrev);
    }
}