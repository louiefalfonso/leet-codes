/*
 * Word Search - 79

 */

 class Solution {
    // Class level variables to hold the dimensions of the board, the word, and the board itself
    private int rows;
    private int cols;
    private String targetWord;
    private char[][] gameBoard;

    // Method to determine if the target word exists in the board
    public boolean exist(char[][] board, String word) {
        rows = board.length;       // Number of rows in the board
        cols = board[0].length;    // Number of columns in the board
        targetWord = word;         // The word we are searching for
        gameBoard = board;         // The game board
      
        // Iterate over every cell in the board
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                // If the first letter matches and dfs search is successful, return true
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
      
        // If we have not returned true at this point, the word does not exist in the board
        return false;
    }

    // Helper method to perform Depth First Search (DFS)
    private boolean dfs(int row, int col, int index) {
        // Check if we are at the last character of the word
        if (index == targetWord.length() - 1) {
            return gameBoard[row][col] == targetWord.charAt(index);
        }
      
        // Check if current cell does not match the character at index in word
        if (gameBoard[row][col] != targetWord.charAt(index)) {
            return false;
        }
      
        // Temporarily mark the current cell as visited by replacing its value
        char tempChar = gameBoard[row][col];
        gameBoard[row][col] = '0';
      
        // Define an array of directions (up, right, down, left)
        int[] directions = {-1, 0, 1, 0, -1};
      
        // Explore all possible adjacent cells (up, right, down, left)
        for (int d = 0; d < 4; ++d) {
            int newRow = row + directions[d];
            int newCol = col + directions[d + 1];
          
            // Check if the new position is within bounds and not visited
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && gameBoard[newRow][newCol] != '0') {
                // If the dfs search from the adjacent cell is successful, return true
                if (dfs(newRow, newCol, index + 1)) {
                    return true;
                }
            }
        }
      
        // Reset the cell's value back from '0' to its original character
        gameBoard[row][col] = tempChar;
      
        // If none of the adjacent cells leads to a solution, return false
        return false;
    }
}
