/*
 * Insert Interval - 57
 */

 import java.util.*;

 class Solution {
  
     public int[][] insert(int[][] intervals, int[] newInterval) {
         // Create a new array to hold the original intervals and the new interval
         int[][] newIntervals = new int[intervals.length + 1][2];
         // Copy the original intervals into the new array
         for (int i = 0; i < intervals.length; ++i) {
             newIntervals[i] = intervals[i];
         }
         // Add the new interval to the end of the new array
         newIntervals[intervals.length] = newInterval;
         // Merge the intervals and return the result
         return merge(newIntervals);
     }

   
     private int[][] merge(int[][] intervals) {
         // Sort the intervals by their start value
         Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
         // Create a list to hold the merged intervals
         List<int[]> ans = new ArrayList<>();
         // Add the first interval to the list
         ans.add(intervals[0]);
         // Iterate over the remaining intervals
         for (int i = 1; i < intervals.length; ++i) {
             int s = intervals[i][0], e = intervals[i][1];
             // If the current interval does not overlap with the last merged interval, add
             // it to the list
             if (ans.get(ans.size() - 1)[1] < s) {
                 ans.add(intervals[i]);
             } else {
                 // Otherwise, merge the current interval with the last merged interval
                 ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], e);
             }
         }
         // Convert the list of merged intervals back to an array and return it
         return ans.toArray(new int[ans.size()][]);
     }
 }