/*
 * Non-overlapping Intervals - 435
 */

 import java.util.Arrays; // Required for Arrays.sort
import java.util.Comparator; // Required for Comparator

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort the intervals array based on the end time of each interval
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        // Set 'end' as the end time of the first interval
        int end = intervals[0][1];

        // Initialize 'overlaps' to count the number of overlapping intervals
        int overlaps = 0;

        // Iterate through each interval starting from the second one
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval does not overlap with the previous, update 'end'
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {
                // If the current interval overlaps, increment 'overlaps'
                overlaps++;
            }
        }

        // Return the total number of overlapping intervals to be removed
        return overlaps;
    }
}