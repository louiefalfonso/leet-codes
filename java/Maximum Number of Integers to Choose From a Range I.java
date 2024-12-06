/*
 * Maximum Number of Integers to Choose From a Range I - 2554
 */

import java.util.HashSet;
import java.util.Set;

 class Solution {
    // Method that returns the maximum count of distinct integers that can be chosen
    // from 1 to n such that their sum does not exceed maxSum and they are not in the banned list
    public int maxCount(int[] bannedNumbers, int n, int maxAllowedSum) {
        // Create a hash set to store the banned numbers for easy access
        Set<Integer> bannedSet = new HashSet<>(bannedNumbers.length);

        // Populate the bannedSet with numbers from the bannedNumbers array
        for (int number : bannedNumbers) {
            bannedSet.add(number);
        }

        // Initialize answer to store the count of possible numbers and sum to track current sum
        int count = 0;
        int currentSum = 0;

        // Iterate through integers from 1 to n
        for (int i = 1; i <= n && currentSum + i <= maxAllowedSum; ++i) {
            // If the current number is not in the banned set
            if (!bannedSet.contains(i)) {
                // Increment the answer count and add the number to the current sum
                ++count;
                currentSum += i;
            }
        }

        // After the loop, return the total count of selectable numbers that meet the criteria
        return count;
    }
}