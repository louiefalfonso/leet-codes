// Game of Life - 289

class Solution {
    public void gameOfLife(int[][] board) {
        // numRows and numCols hold the dimensions of the board
        int numRows = board.length;
        int numCols = board[0].length;

        // Traverse through every cell of the board
        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < numCols; ++col) {
                // Count live neighbors, initializing at -board[row][col] to offset
                // self-counting if alive
                int liveNeighbors = -board[row][col];
                for (int i = row - 1; i <= row + 1; ++i) {
                    for (int j = col - 1; j <= col + 1; ++j) {
                        // Check if neighbor is within bounds and alive
                        if (i >= 0 && i < numRows && j >= 0 && j < numCols && board[i][j] > 0) {
                            liveNeighbors++;
                        }
                    }
                }

                // Apply the Game of Life rules to determine next state:

                // Rule 1 or Rule 3: Any live cell with fewer than two live neighbors
                // or with more than three live neighbors dies (set to 2 for temporary state)
                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 2;
                }

                // Rule 4: Any dead cell with exactly three live neighbors becomes a live cell
                // (set to -1 for temporary state)
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = -1;
                }
            }
        }

        // Re-traverse the board to rewrite the temporary states to final states
        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < numCols; ++col) {
                // A value of 2 means the cell was previously alive and now is dead
                if (board[row][col] == 2) {
                    board[row][col] = 0;
                }
                // A value of -1 means the cell was previously dead and now is alive
                else if (board[row][col] == -1) {
                    board[row][col] = 1;
                }
            }
        }
    }
}
