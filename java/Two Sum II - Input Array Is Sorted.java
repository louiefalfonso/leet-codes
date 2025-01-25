// Two Sum II - Input Array Is Sorted - 167

class Solution {

    public int[] twoSum(int[] numbers, int target) {

        // Initialize pointers for the two indices to be checked
        int left = 0; // Starting from the beginning of the array
        int right = numbers.length - 1; // Starting from the end of the array

        // Loop continues until the correct pair is found
        while (left < right) {
            // Calculate the sum of the elements at the left and right indices
            int sum = numbers[left] + numbers[right];

            // Check if the sum is equal to the target
            if (sum == target) {
                // Return the indices of the two numbers,
                // incremented by one to match the problem's one-based indexing requirement
                return new int[] { left + 1, right + 1 };
            }

            // If the sum is less than the target, increment the left index to increase the
            // sum
            if (sum < target) {
                left++;
            } else {
                // If the sum is greater than the target, decrement the right index to decrease
                // the sum
                right--;
            }
        }

        // The problem statement guarantees that exactly one solution exists,
        // so the following statement is unreachable. This return is used to satisfy the
        // syntax requirements.
        return new int[] { -1, -1 };
    }
}