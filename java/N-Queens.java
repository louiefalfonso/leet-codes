// N-Queens - 51
import java.util.*;

class Solution {
    
    // List to store the final solutions
    private List<List<String>> ans = new ArrayList<>();
    // Array to store the column positions of queens
    private int[] col;
    // Array to store the diagonal positions of queens
    private int[] dg;
    // Array to store the anti-diagonal positions of queens
    private int[] udg;
    // 2D array to store the board state
    private String[][] g;
    // Size of the board
    private int n;

    public List<List<String>> solveNQueens(int n) {
        // Set the board size
        this.n = n;
        // Initialize the column, diagonal, and anti-diagonal arrays
        col = new int[n];
        dg = new int[n << 1];
        udg = new int[n << 1];
        // Initialize the board state array
        g = new String[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], ".");
        }
        // Start the depth-first search to find solutions
        dfs(0);
        return ans;
    }

    // Depth-first search function to find solutions
    private void dfs(int i) {
        // Base case: all queens have been placed
        if (i == n) {
            // Convert the board state array to a list of strings
            List<String> t = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                t.add(String.join("", g[j]));
            }
            // Add the solution to the list
            ans.add(t);
            return;
        }
        // Iterate over all possible column positions for the current queen
        for (int j = 0; j < n; ++j) {
            // Check if the current position is valid
            if (col[j] + dg[i + j] + udg[n - i + j] == 0) {
                // Place the queen in the current position
                g[i][j] = "Q";
                col[j] = dg[i + j] = udg[n - i + j] = 1;
                // Recursively search for solutions in the next row
                dfs(i + 1);
                // Backtrack and remove the queen from the current position
                col[j] = dg[i + j] = udg[n - i + j] = 0;
                g[i][j] = ".";
            }
        }
    }
}