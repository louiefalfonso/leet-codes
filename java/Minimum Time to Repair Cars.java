// Minimum Time to Repair Cars - 2594

class Solution {
    // Method to calculate the minimum time required to repair a given number of cars
    public long repairCars(int[] ranks, int cars) {
        // Initialize binary search boundaries
        long left = 0, right = 1L * ranks[0] * cars * cars;
        
        // Perform binary search to find the minimum time
        while (left < right) {
            long mid = (left + right) >> 1; // Calculate mid-point
            long cnt = 0; // Counter for the number of cars that can be repaired in 'mid' time
            
            // Calculate the number of cars that can be repaired by each mechanic in 'mid' time
            for (int r : ranks) {
                cnt += Math.sqrt(mid / r); // Add the number of cars a mechanic with rank 'r' can repair
            }
            
            // Check if the total number of cars that can be repaired is at least 'cars'
            if (cnt >= cars) {
                right = mid; // If yes, try a smaller time
            } else {
                left = mid + 1; // If no, try a larger time
            }
        }
        
        // Return the minimum time required to repair the cars
        return left;
    }
}