/*
 You are given a a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:
 
 1. Each row must contain the digits 1-9 without duplicates.
 2. Each column must contain the digits 1-9 without duplicates.
 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
 
 Return true if the Sudoku board is valid, otherwise return false
 
 Note: A board does not need to be full or be solvable to be valid.
 */

import java.util.HashSet;
import java.util.Set;

 class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use sets to track seen numbers
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    // Create unique keys for rows, columns and boxes
                    String rowKey = "row" + i + num;
                    String colKey = "col" + j + num;
                    String boxKey = "box" + (i / 3) + (j / 3) + num;

                    // Check if the number has already been seen
                    if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)) {
                        return false;
                    }

                    // Add the number to the set
                    seen.add(rowKey);
                    seen.add(colKey);
                    seen.add(boxKey);
                }
            }
        }

        return true; // If no duplicates were found, the board is valid
    }
}
