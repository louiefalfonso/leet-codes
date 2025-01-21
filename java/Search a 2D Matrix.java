// Search a 2D Matrix - 74

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        // Get the number of rows and columns from the matrix.
        int rows = matrix.length, cols = matrix[0].length;

        // Initialize the left and right pointers for the binary search.
        int left = 0, right = rows * cols - 1;

        // Loop until the search space is reduced to one element.
        while (left < right) {
            // Calculate the middle point of the current search space.
            int mid = (left + right) / 2; // Shift operator can also be used (left + right) >> 1

            // Map the middle index to a 2D position in the matrix.
            int x = mid / cols, y = mid % cols;

            // Compare the middle element with the target.
            if (matrix[x][y] >= target) {
                // If the middle element is greater or equal to the target,
                // narrow the search to the left half including mid.
                right = mid;
            } else {
                // If the middle element is less than the target,
                // narrow the search to the right half excluding mid.
                left = mid + 1;
            }
        }

        // After exiting the loop, left should point to the target element, if it
        // exists.
        // Check if the element at the 'left' position equals the target.
        return matrix[left / cols][left % cols] == target;
    }
}
