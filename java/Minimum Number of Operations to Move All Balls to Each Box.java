/*
 * Minimum Number of Operations to Move All Balls to Each Box - 1769
 */

 class Solution {
    public int[] minOperations(String boxes) {
        // Get the length of the input string
        int length = boxes.length();
        // Initialize the answer array with the same length
        int[] operations = new int[length];

        // Forward pass to calculate the operations required for each box from the left
        for (int i = 1, count = 0; i < length; ++i) {
            // If the previous box contains a ball, increment the count
            if (boxes.charAt(i - 1) == '1') {
                ++count;
            }
            // Accumulate the number of operations required for the current box
            operations[i] = operations[i - 1] + count;
        }

        // Backward pass to calculate the operations required for each box from the
        // right
        for (int i = length - 2, count = 0, sum = 0; i >= 0; --i) {
            // If the next box contains a ball, increment the count
            if (boxes.charAt(i + 1) == '1') {
                ++count;
            }
            // Accumulate the number of operations required from the right side
            sum += count;
            // Add the right side operations to the current box's operations
            operations[i] += sum;
        }

        // Return the final array with minimum operations required for each box
        return operations;
    }
}
