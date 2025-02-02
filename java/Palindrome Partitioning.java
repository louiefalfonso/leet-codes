// Palindrome Partitioning - 131
import java.util.*;

class Solution {
    
    // Store the length of the input string
    private int n;

    // Store the input string
    private String s;

    // Create a 2D boolean array to store whether each substring is a palindrome
    private boolean[][] f;

    // Store the current partition being built
    private List<String> t = new ArrayList<>();

    // Store the final list of all partitions
    private List<List<String>> ans = new ArrayList<>();

    
     //Partitions a string into all possible palindrome partitions.
    public List<List<String>> partition(String s) {
        // Initialize the length of the input string
        n = s.length();

        // Initialize the 2D boolean array to store whether each substring is a
        // palindrome
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            // Assume all substrings are palindromes initially
            Arrays.fill(f[i], true);
        }

        // Fill in the 2D boolean array using dynamic programming
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                // A substring is a palindrome if its first and last characters are equal
                // and the substring in between is also a palindrome
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
            }
        }

        // Store the input string
        this.s = s;

        // Start the depth-first search from the beginning of the string
        dfs(0);

        // Return the final list of all partitions
        return ans;
    }

    
     //Performs a depth-first search to build all possible palindrome partitions.
    private void dfs(int i) {
        // If we have reached the end of the string, add the current partition to the
        // result
        if (i == s.length()) {
            ans.add(new ArrayList<>(t));
            return;
        }

        // Try all possible substrings starting from the current index
        for (int j = i; j < n; ++j) {
            // If the substring is a palindrome, add it to the current partition and recurse
            if (f[i][j]) {
                t.add(s.substring(i, j + 1));
                dfs(j + 1);
                // Backtrack by removing the last substring from the current partition
                t.remove(t.size() - 1);
            }
        }
    }
}