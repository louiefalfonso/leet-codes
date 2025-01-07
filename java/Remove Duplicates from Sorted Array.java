// Remove Duplicates from Sorted Array - 26

class Solution {
    public int removeDuplicates(int[] nums) {
        // Initialize the count for unique elements
        int uniqueCount = 0;

        // Iterate over each element in the array
        for (int currentNum : nums) {
            // If it's the first element or is not equal to the previous element
            // (which means it's not a duplicate)
            if (uniqueCount == 0 || currentNum != nums[uniqueCount - 1]) {
                // Assign the current number to the next unique position in the array
                nums[uniqueCount++] = currentNum;
            }
        }

        // Return the count of unique elements, which is also the new length of the array
        return uniqueCount;
    }
}
