// Maximum Count of Positive Integer and Negative Integer - 2529

class Solution {
    // Method to find the maximum count of either positive or negative integers in the array
    public int maximumCount(int[] nums) {
        int a = 0, b = 0; // Initialize counters for positive (a) and negative (b) integers
        
        // Iterate through each number in the array
        for (int x : nums) {
            if (x > 0) {
                ++a; // Increment positive counter if the number is positive
            } else if (x < 0) {
                ++b; // Increment negative counter if the number is negative
            }
        }
        
        // Return the maximum of the two counters
        return Math.max(a, b);
    }
}