/*
 Two Integer Sum II
 
 Given an array of integers numbers that is sorted in non-decreasing order.
 
 Return the indices (1-indexed) of two numbers, [index1, index2], such that
 they add up to a given target number target and index1 < index2. 
 Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.
 
 There will always be exactly one valid solution.

 Example 1:
 Input: numbers = [1,2,3,4], target = 3
 Output: [1,2]

 */

 class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0; // Start pointer
        int right = numbers.length - 1; // End pointer

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            if (currentSum == target) {
                return new int[] { left + 1, right + 1 }; // Return 1-based indices
            } else if (currentSum < target) {
                left++; // Move left pointer to the right to increase the sum
            } else {
                right--; // Move right pointer to the left to decrease the sum
            }
        }

        // If no solution is found, return an empty array or throw an exception
        return new int[0]; // Just a fallback; the problem guarantees a solution
    }
}
