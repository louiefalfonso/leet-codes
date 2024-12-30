/*
 * Next Permutation - 31
 */

 class Solution {
    public void nextPermutation(int[] nums) {
        // Length of the array
        int length = nums.length;
        // Initialize the index i to start from the second last element
        int i = length - 2;

        // Find the first pair of two successive numbers a[i] and a[i+1], from right to
        // left, which satisfy a[i] < a[i+1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // If such pair was found, i denotes the pivot
        if (i >= 0) {
            // Find the rightmost successor to the pivot
            for (int j = length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    // Swap the successor and the pivot
                    swap(nums, i, j);
                    break;
                }
            }
        }

        // Reverse the suffix starting right after the pivot point
        int start = i + 1, end = length - 1;
        while (start < end) {
            // Swap the start and end elements of the suffix
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // Helper function to swap elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
