/*
 * Climbing Stairs - 70
 */

 class Solution {
  
    // This method calculates the number of distinct ways to climb to the top.
    public int climbStairs(int n) {
        int first = 0, second = 1;
      
        // Loop through number of steps n
        for (int i = 0; i < n; i++) {
            // Calculate next number in the series
            int next = first + second;
          
            // Update the previous two numbers for next iteration
            first = second;
            second = next;
        }
      
        // The 'second' variable holds the total ways to reach the top
        return second;
    }
}