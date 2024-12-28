/*
 * Maximum Sum of 3 Non-Overlapping Subarrays - 689 (Sliding Window)
 */

 class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // Initialize an array to store the indices of the three subarrays
        int[] ans = new int[3];

        // Initialize variables to keep track of the sum of the subarrays
        int s = 0, s1 = 0, s2 = 0, s3 = 0;

        // Initialize variables to keep track of the maximum sum of the subarrays
        int mx1 = 0, mx12 = 0;

        // Initialize variables to keep track of the indices of the subarrays
        int idx1 = 0, idx121 = 0, idx122 = 0;

        // Iterate over the array
        for (int i = k * 2; i < nums.length; ++i) {

            // Update the sum of the subarrays
            s1 += nums[i - k * 2];
            s2 += nums[i - k];
            s3 += nums[i];

            // Check if we have reached the end of the first subarray
            if (i >= k * 3 - 1) {

                // Check if the sum of the first subarray is greater than the maximum sum
                if (s1 > mx1) {
                    mx1 = s1;
                    idx1 = i - k * 3 + 1;
                }

                // Check if the sum of the first and second subarrays is greater than the
                // maximum sum
                if (mx1 + s2 > mx12) {
                    mx12 = mx1 + s2;
                    idx121 = idx1;
                    idx122 = i - k * 2 + 1;
                }

                // Check if the sum of the first, second, and third subarrays is greater than
                // the maximum sum
                if (mx12 + s3 > s) {
                    s = mx12 + s3;
                    ans = new int[] { idx121, idx122, i - k + 1 };
                }

                // Update the sum of the subarrays by subtracting the first element
                s1 -= nums[i - k * 3 + 1];
                s2 -= nums[i - k * 2 + 1];
                s3 -= nums[i - k + 1];
            }
        }

        // Return the indices of the three subarrays
        return ans;
    }
}