// Maximum Ascending Subarray Sum - 1800

class Solution {
    
     //Returns the maximum ascending sum of a subarray in the given array.
    public int maxAscendingSum(int[] nums) {
        // Initialize variables to keep track of the maximum sum and the current sum.
        int ans = 0, t = 0;

        // Iterate through the array.
        for (int i = 0; i < nums.length; ++i) {
            // If this is the first element or the current element is greater than the
            // previous one,
            // add it to the current sum and update the maximum sum if necessary.
            if (i == 0 || nums[i] > nums[i - 1]) {
                t += nums[i];
                ans = Math.max(ans, t);
            }
            // If the current element is not greater than the previous one, start a new sum.
            else {
                t = nums[i];
            }
        }
        // Return the maximum ascending sum.
        return ans;
    }
}