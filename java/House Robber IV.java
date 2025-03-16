// House Robber IV - 2560

class Solution {
    // Method to find the minimum capability required to rob at least 'k' houses
    public int minCapability(int[] nums, int k) {
        // Initialize binary search boundaries
        int left = 0, right = (int) 1e9;
        
        // Perform binary search to find the minimum capability
        while (left < right) {
            int mid = (left + right) >> 1; // Calculate mid-point
            
            // Check if it's possible to rob at least 'k' houses with capability 'mid'
            if (f(nums, mid) >= k) {
                right = mid; // If yes, try a smaller capability
            } else {
                left = mid + 1; // If no, try a larger capability
            }
        }
        
        // Return the minimum capability required
        return left;
    }

    // Helper method to calculate the number of houses that can be robbed with capability 'x'
    private int f(int[] nums, int x) {
        int cnt = 0; // Counter for the number of houses that can be robbed
        int j = -2; // Index of the last house robbed, initialized to -2 to allow robbing the first house
        
        // Iterate through each house
        for (int i = 0; i < nums.length; ++i) {
            // Skip the house if its value is greater than 'x' or it's adjacent to the last robbed house
            if (nums[i] > x || i == j + 1) {
                continue;
            }
            ++cnt; // Increment the counter for a robbable house
            j = i; // Update the index of the last house robbed
        }
        
        // Return the total number of houses that can be robbed
        return cnt;
    }
}