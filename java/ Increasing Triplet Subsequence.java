/*
 Increasing Triplet Subsequence - 334

 Given an integer array nums, return true if there exists a triple of indices 
 (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
 */

 class Solution {

    // Method to check if there exists an increasing triplet in the array.
    public boolean increasingTriplet(int[] nums) {
        // Initialize two variables to hold the smallest and the middle value found so far.
        int smallest = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;

        // Iterate over each number in the array.
        for (int num : nums) {
            // If the current number is greater than the middle value found,
            // an increasing triplet sequence exists.
            if (num > middle) {
                return true;
            }

            // If the current number is the smallest we've seen so far,
            // we update the smallest value.
            if (num <= smallest) {
                smallest = num;
            } else {
                // Otherwise, if it's between the smallest and the middle value,
                // we update the middle value.
                middle = num;
            }
        }

        // If we did not return true within the loop, then no increasing
        // triplet sequence was found.
        return false;
    }
}