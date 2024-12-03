/*
Longest Consecutive Sequence

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

         // Use a HashSet to store the numbers for O(1) lookups
         HashSet<Integer> numSet = new HashSet<>();
         for (int num : nums) {
             numSet.add(num);
         }

         int longestStreak = 0;

         for (int num : numSet) {
             // Only check for the start of a sequence
             if (!numSet.contains(num - 1)) {
                 int currentNum = num;
                 int currentStreak = 1;

                 // Count the length of the sequence
                 while (numSet.contains(currentNum + 1)) {
                     currentNum++;
                     currentStreak++;
                 }

                 // Update the longest streak found
                 longestStreak = Math.max(longestStreak, currentStreak);
             }
         }

         return longestStreak;
     }
 }
