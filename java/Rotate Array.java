// Rotate Array - 189

class Solution {

    private int[] nums;

    public void rotate(int[] nums, int k) {
        // Assign the input array to the class-level variable
        this.nums = nums;

        // Number of elements in the array
        int n = nums.length;

        // Normalize the number of steps k to avoid extra rotations
        k %= n;

        // Reverse the entire array
        reverse(0, n - 1);

        // Reverse the first part (up to k elements)
        reverse(0, k - 1);

        // Reverse the second part (from k to the end of the array)
        reverse(k, n - 1);
    }


    private void reverse(int i, int j) {
        // Using two pointers approach, swap elements until pointers meet or cross
        while (i < j) {
            // Temporary variable to hold a value during the swap
            int temp = nums[i];

            // Perform swap
            nums[i] = nums[j];
            nums[j] = temp;

            // Move pointers towards each other
            ++i;
            --j;
        }
    }
}