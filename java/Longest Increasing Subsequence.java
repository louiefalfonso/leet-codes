/*
 * Longest Increasing Subsequence - 300
 */
import java.util.*;

class Solution {
    
    public int lengthOfLIS(int[] nums) {
        // Get the length of the input array.
        int n = nums.length;

        // Create an array to store the length of the longest increasing subsequence
        // ending at each position.
        int[] f = new int[n];

        // Initialize all values in the array to 1, since a single element is always an
        // increasing subsequence.
        Arrays.fill(f, 1);

        // Initialize the maximum length of the longest increasing subsequence found so
        // far.
        int ans = 1;

        // Iterate over the array starting from the second element.
        for (int i = 1; i < n; ++i) {
            // Iterate over all previous elements.
            for (int j = 0; j < i; ++j) {
                // If the current element is greater than the previous element, it can be part
                // of an increasing subsequence.
                if (nums[j] < nums[i]) {
                    // Update the length of the longest increasing subsequence ending at the current
                    // position.
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            // Update the maximum length of the longest increasing subsequence found so far.
            ans = Math.max(ans, f[i]);
        }
        // Return the maximum length of the longest increasing subsequence.
        return ans;
    }
}