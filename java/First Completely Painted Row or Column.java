// First Completely Painted Row or Column - 2661

import java.util.Map;
import java.util.HashMap;

class Solution {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        // Dimensions of the matrix
        int rowCount = mat.length;
        int colCount = mat[0].length;

        // Mapping from the value to its coordinates in the matrix
        Map<Integer, int[]> valueToIndexMap = new HashMap<>();
        for (int row = 0; row < rowCount; ++row) {
            for (int col = 0; col < colCount; ++col) {
                valueToIndexMap.put(mat[row][col], new int[] { row, col });
            }
        }

        // Arrays to keep track of the number of values found per row and column
        int[] rowCompletion = new int[rowCount];
        int[] colCompletion = new int[colCount];

        // Iterate through the array `arr`
        for (int k = 0;; ++k) {
            // Get the coordinates of the current array value in the matrix
            int[] coordinates = valueToIndexMap.get(arr[k]);
            int rowIndex = coordinates[0];
            int colIndex = coordinates[1];

            // Increment the counters for the row and column
            rowCompletion[rowIndex]++;
            colCompletion[colIndex]++;

            // Check if the current row or column is completed
            if (rowCompletion[rowIndex] == colCount || colCompletion[colIndex] == rowCount) {
                // Return the current index if a row or column is complete
                return k;
            }
        }
    }
}
