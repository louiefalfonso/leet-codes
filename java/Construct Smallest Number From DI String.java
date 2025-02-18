// Construct Smallest Number From DI String - 2375

class Solution {
    
    // Array to keep track of visited digits (1-9)
    private boolean[] vis = new boolean[10];
    // StringBuilder to construct the result string
    private StringBuilder t = new StringBuilder();
    // Pattern string
    private String p;
    // Result string
    private String ans;

    // Main function to find the smallest number that matches the pattern
    public String smallestNumber(String pattern) {
        p = pattern;
        dfs(0);
        return ans;
    }

    // Depth-first search function to explore all possible combinations
    private void dfs(int u) {
        // If a solution is already found, return immediately
        if (ans != null) {
            return;
        }
        // If we have reached the end of the pattern, update the result if necessary
        if (u == p.length() + 1) {
            ans = t.toString();
            return;
        }
        // Try each digit from 1 to 9
        for (int i = 1; i < 10; ++i) {
            // Skip if the digit is already visited
            if (!vis[i]) {
                // Check if the current digit is valid based on the pattern
                if (u > 0 && p.charAt(u - 1) == 'I' && t.charAt(u - 1) - '0' >= i) {
                    continue;
                }
                if (u > 0 && p.charAt(u - 1) == 'D' && t.charAt(u - 1) - '0' <= i) {
                    continue;
                }
                // Mark the digit as visited and append it to the result string
                vis[i] = true;
                t.append(i);
                // Recursively explore the next digit
                dfs(u + 1);
                // Backtrack by removing the last digit and marking it as unvisited
                t.deleteCharAt(t.length() - 1);
                vis[i] = false;
            }
        }
    }
}