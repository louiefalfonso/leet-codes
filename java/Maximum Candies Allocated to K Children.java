// Maximum Candies Allocated to K Children - 2226
import java.util.*;

class Solution {
    // Method to find the maximum number of candies that can be allocated to each child
    public int maximumCandies(int[] candies, long k) {
        // Initialize binary search boundaries
        int l = 0, r = Arrays.stream(candies).max().getAsInt();
        
        // Perform binary search to find the maximum number of candies per child
        while (l < r) {
            int mid = (l + r + 1) >> 1; // Calculate mid-point, adding 1 to avoid infinite loop
            long cnt = 0; // Counter for the total number of children that can receive 'mid' candies
            
            // Calculate the total number of children that can receive 'mid' candies
            for (int x : candies) {
                cnt += x / mid; // Add the number of children that can receive candies from each pile
            }
            
            // Check if the total number of children that can receive 'mid' candies is at least 'k'
            if (cnt >= k) {
                l = mid; // If yes, try a larger number of candies per child
            } else {
                r = mid - 1; // If no, try a smaller number of candies per child
            }
        }
        
        // Return the maximum number of candies that can be allocated to each child
        return l;
    }
}