/*
Longest Consecutive Sequence -128

Given an array of integers nums, return the length of the longest consecutive
sequence of elements that can be formed.
 
A consecutive sequence is a sequence of elements in which each element is
exactly 1 greater than the previous element. The elements do not have to be
consecutive in the original array.
 
You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [2,20,4,10,3,4,5]
Output: 4

Example 2:
Input: nums = [0,3,2,5,4,6,1,1]
Output: 7
 
 */

 import java.util.HashSet;

 class Solution {
     public int longestConsecutive(int[] nums) {
         // Create a HashSet to store the numbers for efficient lookups
         HashSet<Integer> numSet = new HashSet<>();
         for (int num : nums) {
             numSet.add(num);
         }

         // Initialize the longest streak to 0
         int longestStreak = 0;

         // Iterate through the numbers in the set
         for (int num : numSet) {
             // Check if the current number is the start of a sequence (i.e., `num - 1` is
             // not in the set)
             if (!numSet.contains(num - 1)) {
                 int currentNum = num;
                 int currentStreak = 1;

                 // Keep incrementing the current number and streak as long as the next number is
                 // in the set
                 while (numSet.contains(currentNum + 1)) {
                     currentNum++;
                     currentStreak++;
                 }

                 // Update the longest streak if the current streak is longer
                 longestStreak = Math.max(longestStreak, currentStreak);
             }
         }

         // Return the longest streak found
         return longestStreak;
     }
 }
