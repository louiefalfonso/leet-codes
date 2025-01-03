/*
 * Number of Ways to Split Array - 2270
 */

 class Solution {
    public int waysToSplitArray(int[] nums) {
        // Calculate the total sum of the array elements
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Initialize the count of ways to split the array
        int countWays = 0;
        // Temporary sum to keep track of the sum of the first part of the array
        long tempSum = 0;

        // Iterate through the array elements, except the last one
        for (int i = 0; i < nums.length - 1; ++i) {
            // Add the current element to the temporary sum
            tempSum += nums[i];
            // Compare the temporary sum with the sum of the remaining elements
            if (tempSum >= totalSum - tempSum) {
                // If the temporary sum is greater than or equal to the remaining sum,
                // increment the count of ways to split the array
                ++countWays;
            }
        }

        // Return the total count of ways to split the array
        return countWays;
    }
}