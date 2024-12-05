/*
 * Max Number of K-Sum Pairs - 1679
 */

 import java.util.Arrays;
 
 class Solution {
    public int maxOperations(int[] nums, int k) {
        // Sort the array to use two pointers approach
        Arrays.sort(nums);

        // Initialize two pointers, one at the start (left) and one at the end (right)
        // of the array
        int left = 0, right = nums.length - 1;

        // Initialize the answer variable to count the number of operations
        int answer = 0;

        // Use a while loop to move the two pointers towards each other
        while (left < right) {
            // Calculate the sum of the two-pointer elements
            int sum = nums[left] + nums[right];

            // Check if the sum is equal to k
            if (sum == k) {
                // If it is, increment the number of operations
                ++answer;
                // Move the left pointer to the right and the right pointer to the left
                ++left;
                --right;
            } else if (sum > k) {
                // If the sum is greater than k, we need to decrease the sum
                // We do this by moving the right pointer to the left
                --right;
            } else {
                // If the sum is less than k, we need to increase the sum
                // We do this by moving the left pointer to the right
                ++left;
            }
        }
        // Return the total number of operations
        return answer;
    }
}
