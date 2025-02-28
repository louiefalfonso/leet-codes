// Shortest Common Supersequence - 1092

class Solution {
    
     // Returns the shortest common supersequence of two strings.
    public String shortestCommonSupersequence(String str1, String str2) {
        // Get the lengths of the two strings
        int m = str1.length(), n = str2.length();

        // Create a 2D array to store the lengths of the longest common subsequences
        int[][] f = new int[m + 1][n + 1];

        // Initialize the first row and column of the array
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                // If the current characters in both strings are the same,
                // the length of the longest common subsequence is one more than the diagonal
                // value
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                }
                // Otherwise, the length of the longest common subsequence is the maximum of the
                // values to the left and top
                else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }

        // Initialize variables to store the result and the current positions in the
        // strings
        int i = m, j = n;
        StringBuilder ans = new StringBuilder();

        // Build the shortest common supersequence by backtracking from the bottom-right
        // corner of the array
        while (i > 0 || j > 0) {
            // If we've reached the end of str1, append the remaining characters of str2
            if (i == 0) {
                ans.append(str2.charAt(--j));
            }
            // If we've reached the end of str2, append the remaining characters of str1
            else if (j == 0) {
                ans.append(str1.charAt(--i));
            }
            // Otherwise, append the character that corresponds to the maximum value in the
            // array
            else {
                if (f[i][j] == f[i - 1][j]) {
                    ans.append(str1.charAt(--i));
                } else if (f[i][j] == f[i][j - 1]) {
                    ans.append(str2.charAt(--j));
                } else {
                    ans.append(str1.charAt(--i));
                    --j;
                }
            }
        }

        // Return the shortest common supersequence as a string
        return ans.reverse().toString();
    }
}