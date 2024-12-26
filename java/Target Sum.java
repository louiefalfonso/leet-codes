/*
 * Target Sum - 494
 */

 class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // Initialize the sum of all numbers in nums
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
      
        // If the sum is less than the target or (sum - target) is odd, it's not possible to partition
        if (sum < target || (sum - target) % 2 != 0) {
            return 0;
        }
      
        // Compute the subset sum needed for one side of the partition
        int subsetSum = (sum - target) / 2;
      
        // Initialize a DP array to store the number of ways to reach a particular sum
        int[] dp = new int[subsetSum + 1];
      
        // There's one way to reach the sum of 0 - by not including any numbers
        dp[0] = 1;
      
        // Go through every number in nums
        for (int num : nums) {
            // Update the DP table from the end to the start to avoid overcounting
            for (int j = subsetSum; j >= num; j--) {
                // Increase the current dp value by the value from dp[j - num]
                dp[j] += dp[j - num];
            }
        }
      
        // Return the number of ways to reach the target sum
        return dp[subsetSum];
    }
 }    