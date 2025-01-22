// Find the Duplicate Number - 287

class Solution {
    public int findDuplicate(int[] nums) {
        // Initializing the low and high pointers for binary search.
        int low = 0;
        int high = nums.length - 1;

        // Binary search to find the duplicate number.
        while (low < high) {
            // Calculating the middle index.
            int middle = (low + high) / 2; // same as (low + high) >> 1 but clearer to understand
            int count = 0; // Counter for the number of elements less than or equal to middle.

            // Iterate over the array and count elements less than or equal to middle.
            for (int value : nums) {
                if (value <= middle) {
                    count++;
                }
            }

            // Determine if the duplicate is in the lower half or upper half.
            // If the count is greater than middle, the duplicate is in the lower half.
            if (count > middle) {
                high = middle; // Narrow the search to the lower half.
            } else {
                low = middle + 1; // Narrow the search to the upper half.
            }
        }

        // When low == high, we have found the duplicate number.
        return low;
    }
}