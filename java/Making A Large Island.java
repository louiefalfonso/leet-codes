// Making A Large Island - 827

import java.util.*;

class Solution {
    
    // Number of rows in the grid
    private int n;
    // Current root island index
    private int root;
    // Count of cells in each island
    private int[] cnt;
    // Parent array to keep track of island indices
    private int[][] p;
    // Input grid
    private int[][] grid;
    // Directions for DFS (up, right, down, left)
    private final int[] dirs = { -1, 0, 1, 0, -1 };

    
     // Returns the size of the largest island that can be formed by changing one cell.
    public int largestIsland(int[][] grid) {
        n = grid.length;
        p = new int[n][n];
        this.grid = grid;
        cnt = new int[n * n + 1];
        int ans = 0;

        // First pass: mark all islands and count their sizes
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && p[i][j] == 0) {
                    // New island found, increment root index
                    ++root;
                    // Perform DFS to mark island cells and count size
                    ans = Math.max(ans, dfs(i, j));
                }
            }
        }

        // Second pass: try to expand each water cell into an island
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    // Get neighboring island indices
                    Set<Integer> s = new HashSet<>();
                    for (int k = 0; k < 4; ++k) {
                        int x = i + dirs[k];
                        int y = j + dirs[k + 1];
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            s.add(p[x][y]);
                        }
                    }
                    // Calculate potential island size if this cell is changed to land
                    int t = 1;
                    for (int x : s) {
                        t += cnt[x];
                    }
                    // Update answer if this potential island is larger
                    ans = Math.max(ans, t);
                }
            }
        }
        return ans;
    }

    
     // Performs DFS from the given cell to mark island cells and count size.
    private int dfs(int i, int j) {
        // Mark cell as part of the current island
        p[i][j] = root;
        // Increment island size
        ++cnt[root];
        // Recursively explore neighboring cells
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k];
            int y = j + dirs[k + 1];
            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1 && p[x][y] == 0) {
                dfs(x, y);
            }
        }
        // Return island size
        return cnt[root];
    }
}