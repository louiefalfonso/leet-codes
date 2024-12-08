/*
 * Equal Row and Column Pairs - 2352
 */

 class Solution {
    public int equalPairs(int[][] grid) {
        // Get the length of the grid, which is also the number of rows and columns (n
        // by n)
        int n = grid.length;

        // Create a new grid 'transposedGrid' which will store the transposed version of
        // 'grid'
        int[][] transposedGrid = new int[n][n];

        // Transpose the grid: turn rows of 'grid' into columns of 'transposedGrid'
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < n; ++i) {
                transposedGrid[i][j] = grid[j][i];
            }
        }

        // Initialize a counter for the number of equal pairs
        int equalPairsCount = 0;

        // Iterate through each row of the original grid
        for (var row : grid) {
            // Iterate through each column in the transposed grid
            for (var column : transposedGrid) {
                // Initialize a flag to check if the current row and column are equal
                int areEqual = 1;
                // Compare corresponding elements of the current row and column
                for (int i = 0; i < n; ++i) {
                    if (row[i] != column[i]) {
                        // If there's a mismatch, set the flag to zero and break the loop
                        areEqual = 0;
                        break;
                    }
                }
                // If the row and column are equal, increment the count
                equalPairsCount += areEqual;
            }
        }
        // Return the total count of equal pairs
        return equalPairsCount;
    }
}