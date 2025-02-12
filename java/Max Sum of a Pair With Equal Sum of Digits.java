// Max Sum of a Pair With Equal Sum of Digits - 2342

class Solution {
    
     // Returns the maximum sum that can be obtained by adding two numbers in the array with the same digit sum.
     
    public int maximumSum(int[] nums) {

        // Create an array to store the maximum number for each digit sum
        int[] d = new int[100];
        // Initialize the answer to -1
        int ans = -1;

        // Iterate over each number in the array
        for (int v : nums) {
            // Calculate the digit sum of the current number
            int x = 0;
            for (int y = v; y > 0; y /= 10) {
                x += y % 10;
            }

            // If a number with the same digit sum before,
            // update the answer if the sum of the current number and the previous number is
            // larger
            if (d[x] > 0) {
                ans = Math.max(ans, d[x] + v);
            }

            // Update the maximum number for the current digit sum
            d[x] = Math.max(d[x], v);
        }

        // Return the maximum sum
        return ans;
    }
}