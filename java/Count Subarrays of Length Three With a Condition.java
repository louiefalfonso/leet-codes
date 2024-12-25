/*
 * Count Subarrays of Length Three With a Condition - 3392
 */

 class Solution {

    public int countSubarrays(int[] nums) {
        // Initialize a counter for valid subarrays
        int ans = 0;

        // Iterate through the array starting from the second element
        // and ending at the second to last element
        for (int i = 1; i + 1 < nums.length; ++i) {
            // Check if the middle element is equal to the average of its neighbors
            if ((nums[i - 1] + nums[i + 1]) * 2 == nums[i]) {
                // If the condition is met, increment the counter
                ++ans;
            }
        }

        // Return the total count of valid subarrays
        return ans;
    }
}