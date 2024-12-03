/*
 Given an integer array nums, return an array output where output[i] is the
 product of all the elements of nums except nums[i].
 
 Each product is guaranteed to fit in a 32-bit integer.
 
 Example 1:
 Input: nums = [1,2,4,6]
 Output: [48,24,12,8]

 Example 2:
 Input: nums = [-1,0,1,2,3]
 Output: [0,-6,0,0,0]
 
 */

 class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] output = new int[n];

        // Step 1: Calculate left products
        output[0] = 1; // There are no elements to the left of the first element
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate right products and update the output array
        int rightProduct = 1; // There are no elements to the right of the last element
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= rightProduct; // Multiply with the right product
            rightProduct *= nums[i]; // Update the right product
        }

        return output;

    }
}