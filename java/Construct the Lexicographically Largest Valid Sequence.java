// Construct the Lexicographically Largest Valid Sequence - 1718
import java.util.*;

class Solution {

    // Array to store the constructed sequence
    private int[] path;
    // Array to keep track of the count of each number
    private int[] cnt;
    // Length of the sequence
    private int n;

    
     // Constructs a distanced sequence of length 2n - 1.
    public int[] constructDistancedSequence(int n) {
        this.n = n;
        // Initialize the path and count arrays
        path = new int[n * 2];
        cnt = new int[n * 2];
        Arrays.fill(cnt, 2);
        // 1 appears only once in the sequence
        cnt[1] = 1;
        // Start the depth-first search
        dfs(1);
        // Extract the constructed sequence from the path array
        int[] ans = new int[n * 2 - 1];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = path[i + 1];
        }
        return ans;
    }

    
     // Performs a depth-first search to construct the sequence.
    private boolean dfs(int u) {
        // If we have reached the end of the sequence, return true
        if (u == n * 2) {
            return true;
        }
        // If the current index is already filled, move to the next index
        if (path[u] > 0) {
            return dfs(u + 1);
        }
        // Try to fill the current index with a number from n to 1
        for (int i = n; i > 1; --i) {
            // Check if the number is available and the next index is empty
            if (cnt[i] > 0 && u + i < n * 2 && path[u + i] == 0) {
                // Mark the number as used and fill the current and next indices
                cnt[i] = 0;
                path[u] = i;
                path[u + i] = i;
                // Recursively try to fill the rest of the sequence
                if (dfs(u + 1)) {
                    return true;
                }
                // If the recursive call fails, backtrack and reset the current and next indices
                cnt[i] = 2;
                path[u] = 0;
                path[u + i] = 0;
            }
        }
        // If no number can be placed at the current index, try to place 1
        if (cnt[1] > 0) {
            path[u] = 1;
            cnt[1] = 0;
            // Recursively try to fill the rest of the sequence
            if (dfs(u + 1)) {
                return true;
            }
            // If the recursive call fails, backtrack and reset the current index
            cnt[1] = 1;
            path[u] = 0;
        }
        // If no number can be placed at the current index, return false
        return false;
    }
}