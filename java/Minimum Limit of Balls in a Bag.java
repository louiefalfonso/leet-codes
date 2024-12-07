/*
 Minimum Limit of Balls in a Bag - 1760
 */

 class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1; // Minimum possible limit
        int right = 0; // Maximum possible limit
        for (int num : nums) {
            right = Math.max(right, num); // Find the maximum number of balls in any bag
        }

        while (left < right) {
            int mid = left + (right - left) / 2; // Midpoint of the current range
            if (canDistribute(nums, mid, maxOperations)) {
                right = mid; // Try for a smaller maximum limit
            } else {
                left = mid + 1; // Increase the limit
            }
        }

        return left; // The minimum possible maximum limit
    }

    private boolean canDistribute(int[] nums, int maxLimit, int maxOperations) {
        int operationsNeeded = 0;
        for (int num : nums) {
            if (num > maxLimit) {
                operationsNeeded += (num - 1) / maxLimit; // Calculate operations needed for this bag
            }
            if (operationsNeeded > maxOperations) {
                return false; // If we exceed the allowed operations, return false
            }
        }
        return true; // If we can distribute within the allowed operations
    }
}