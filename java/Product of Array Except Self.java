/*
Product of Array Except Self - 238

Given an integer array nums, return an array answer such that answer[i] 
is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 
Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */

 class Solution {

    // Method to calculate the product of elements except self
    public int[] productExceptSelf(int[] nums) {
        
        // Get the length of the input array
        int length = nums.length;
        // Initialize the answer array with the same length
        int[] result = new int[length];

        // Initialize 'leftProduct' to 1, to represent the product of elements to the
        // left of the current index
        int leftProduct = 1;
        // Loop through the array from left to right
        for (int i = 0; i < length; i++) {
            // Set the current element in the result array to 'leftProduct'
            result[i] = leftProduct;
            // Multiply 'leftProduct' by the current element in nums for the next iteration
            // (prefix product)
            leftProduct *= nums[i];
        }

        // Initialize 'rightProduct' to 1, to represent the product of elements to the
        // right of the current index
        int rightProduct = 1;
        // Loop through the array from right to left
        for (int i = length - 1; i >= 0; i--) {
            // Multiply the current element in the result array by 'rightProduct'
            result[i] *= rightProduct;
            // Multiply 'rightProduct' by the current element in nums for the next iteration
            // (suffix product)
            rightProduct *= nums[i];
        }

        // Return the final product except self array
        return result;
    }
}