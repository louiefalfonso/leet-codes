/*
 * Remove Element - 27
 */

 class Solution {
    public int removeElement(int[] nums, int val) {
        int newLength = 0; // Initialize a counter for the new length of the array
        // Iterate over each element in the array
        for (int num : nums) {
            // If the current element is not the value to be removed, add it to the array's
            // new position
            if (num != val) {
                nums[newLength++] = num;
            }
        }
        return newLength; // The new length of the array after removing the value
    }
}
