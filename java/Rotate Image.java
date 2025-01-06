/*
 * Rotate Image - 48
 */

 class Solution {
    public void rotate(int[][] matrix) {
        // Obtain the length of the matrix which is a square (same width and height)
        int n = matrix.length;

        // Step 1: Perform a vertical flip of the matrix
        // Loop over the first half of the rows (vertically)
        for (int row = 0; row < (n >> 1); ++row) {
            // Loop over all columns
            for (int col = 0; col < n; ++col) {
                // Swap the element at the current position with the element at the mirrored row
                // across the horizontal axis
                int temp = matrix[row][col];
                matrix[row][col] = matrix[n - row - 1][col];
                matrix[n - row - 1][col] = temp;
            }
        }

        // Step 2: Transpose the matrix by flipping it along its diagonal
        // Loop over all rows
        for (int row = 0; row < n; ++row) {
            // Loop over the columns up to the current row (to avoid re-flipping)
            for (int col = 0; col < row; ++col) {
                // Swap the element at (row, col) with the element at (col, row)
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
}