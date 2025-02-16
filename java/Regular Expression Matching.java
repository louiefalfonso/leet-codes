// Regular Expression Matching - 10

class Solution {
    // 2D array to store the results of subproblems
    private Boolean[][] f;
    // Input string
    private String s;
    // Pattern string
    private String p;
    // Length of input string
    private int m;
    // Length of pattern string
    private int n;

    
    // Checks if the input string matches the pattern.
    public boolean isMatch(String s, String p) {
        // Initialize variables
        m = s.length();
        n = p.length();
        f = new Boolean[m + 1][n + 1];
        this.s = s;
        this.p = p;
        // Start the DFS from the beginning of both strings
        return dfs(0, 0);
    }

    
     // Performs a depth-first search to check if the input string matches the pattern. 
    private boolean dfs(int i, int j) {
        
        // If we've reached the end of the pattern string, check if we've also reached
        // the end of the input string
        if (j >= n) {
            return i == m;
        }
        // If we've already computed the result for this subproblem, return it
        if (f[i][j] != null) {
            return f[i][j];
        }
        boolean res = false;
        // Check if the current character in the pattern is followed by a '*'
        if (j + 1 < n && p.charAt(j + 1) == '*') {
            // Try two possibilities:
            // 1. Ignore the '*' and move to the next character in the pattern
            // 2. Use the '*' to match the current character in the input string, and move
            // to the next character in the input string
            res = dfs(i, j + 2) || (i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && dfs(i + 1, j));
        } else {
            // If the current character in the pattern is not followed by a '*', check if it
            // matches the current character in the input string
            res = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && dfs(i + 1, j + 1);
        }
        // Store the result of this subproblem and return it
        return f[i][j] = res;
    }
}