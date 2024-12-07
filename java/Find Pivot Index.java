/*
 Find Pivot Index - 724
 */

 class Solution {
    public int pivotIndex(int[] nums) {
        // Initialize the sum of numbers to the left of the pivot to 0
        int sumLeft = 0;

        // Calculate the total sum of the array elements
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Iterate through the array to find the pivot index
        for (int i = 0; i < nums.length; i++) {
            // Right sum is total sum minus the current element
            // since the current element is to be the pivot
            int sumRight = totalSum - sumLeft - nums[i];

            // If the sum of numbers to the left of the pivot is equal to
            // the sum of numbers to the right of the pivot, return current index
            if (sumLeft == sumRight) {
                return i;
            }

            // Update the sumLeft by adding the current element's value
            sumLeft += nums[i];
        }

        // If no pivot index is found, return -1
        return -1;
    }
}
