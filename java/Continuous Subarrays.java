/*
 * Continuous Subarrays - 2762
 */

 import java.util.*;
 
 class Solution {
    public long countContinuousSubarrays(int[] nums) {
        // Initialize the result count
        long totalCount = 0;
        // Initialize two pointers for the sliding window
        int windowStart = 0;
        int n = nums.length;
        // TreeMap to keep track of the frequency of each number in the current window
        // The TreeMap's keys are sorted, so we can efficiently access the smallest and
        // largest values
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();

        // Iterate over all elements in the array using the 'windowEnd' pointer
        for (int windowEnd = 0; windowEnd < n; ++windowEnd) {
            // Increment the frequency of the current number, initializing it to 1 if it
            // doesn't exist
            frequencyMap.merge(nums[windowEnd], 1, Integer::sum);
            // Shrink the window from the left if the condition is breached:
            // The difference between the maximum and minimum is greater than 2
            while (frequencyMap.lastEntry().getKey() - frequencyMap.firstEntry().getKey() > 2) {
                // Reduce the frequency of the number at 'windowStart'
                frequencyMap.merge(nums[windowStart], -1, Integer::sum);
                // If the frequency drops to 0, remove it from the map
                if (frequencyMap.get(nums[windowStart]) == 0) {
                    frequencyMap.remove(nums[windowStart]);
                }
                // Move the start of the window forward
                ++windowStart;
            }
            // Add the number of subarrays ending at 'windowEnd' which are valid
            totalCount += windowEnd - windowStart + 1;
        }
        // Return the total number of continuous subarrays found
        return totalCount;
    }
}