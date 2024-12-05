/*
 Find Minimum in Rotated Sorted Array -153
 */

 class Solution {
    public int findMin(int[] nums) {
        int length = nums.length; // Store the length of the array for quick access

        // If the first element is less than or equal to the last element,
        // the minimum element must be at the starting index since the array is not
        // rotated.
        if (nums[0] <= nums[length - 1]) {
            return nums[0];
        }

        // Initialize pointers for binary search
        int left = 0;
        int right = length - 1;

        // Conduct binary search to find the minimum element index
        while (left < right) {

            // Midpoint calculation
            int mid = left + (right - left) / 2;

            // Compare middle element with the first element to decide where to continue the
            // search.
            // If nums[0] is less than or equal to nums[mid], the rotation index must be to
            // the right
            // of mid, hence we adjust left to mid + 1.
            if (nums[0] <= nums[mid]) {
                left = mid + 1;
            } else {
                // If nums[0] is greater than nums[mid], the rotation index must be at mid or
                // to the left of mid, hence we adjust right to mid.
                right = mid;
            }
        }

        // After the search, left would be pointing at the minimum element in the
        // rotated array.
        return nums[left];
    }
}
