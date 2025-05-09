// Minimum Size Subarray Sum - 209

class Solution {

    // This method finds the minimum length of a subarray that sums to at least the given target.
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length; // The length of the input array.
        long sum = 0; // The sum of the current subarray.
        int minLength = n + 1; // Initialize minLength with max possible value plus one for comparison.

        // Two pointers method: i is the end-pointer, j is the start-pointer of the
        // sliding window.
        for (int end = 0, start = 0; end < n; ++end) {
            sum += nums[end]; // Increment the sum by the current element value.

            // Shrink the window from the left until the sum is smaller than the target.
            // This finds the smallest window that ends at position 'end'.
            while (start < n && sum >= target) {
                minLength = Math.min(minLength, end - start + 1); // Update minLength if a smaller length is found.
                sum -= nums[start++]; // Decrease the sum by the start-value and increment start-pointer to shrink the
                                      // window.
            }
        }

        // If minLength is updated (smaller than n + 1), we found a valid subarray.
        // Otherwise, return 0 as a subarray meeting the conditions is not found.
        return minLength <= n ? minLength : 0;
    }
}