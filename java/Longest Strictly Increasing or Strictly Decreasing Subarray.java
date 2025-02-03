// Longest Strictly Increasing or Strictly Decreasing Subarray - 3105

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        // Initialize the answer to 1, since a single element is always monotonic
        int ans = 1;

        // Iterate through the array to find the longest increasing subarray
        for (int i = 1, t = 1; i < nums.length; ++i) {
            // If the current element is greater than the previous one, increment the
            // counter
            if (nums[i - 1] < nums[i]) {
                ans = Math.max(ans, ++t); // Update the answer if the current subarray is longer
            }
            // If the current element is not greater than the previous one, reset the
            // counter
            else {
                t = 1;
            }
        }

        // Iterate through the array to find the longest decreasing subarray
        for (int i = 1, t = 1; i < nums.length; ++i) {
            // If the current element is less than the previous one, increment the counter
            if (nums[i - 1] > nums[i]) {
                ans = Math.max(ans, ++t); // Update the answer if the current subarray is longer
            }
            // If the current element is not less than the previous one, reset the counter
            else {
                t = 1;
            }
        }

        // Return the maximum length of the monotonic subarrays
        return ans;
    }
}