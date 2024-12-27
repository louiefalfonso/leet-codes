/*
 * Edit Distance - 72
 */

 class Solution {
    public int minDistance(String word1, String word2) {
        // Lengths of the input strings
        int m = word1.length(), n = word2.length();

        // Create a 2D array to store the edit distances between substrings of word1 and
        // word2
        int[][] f = new int[m + 1][n + 1];

        // Initialize the base case: transforming an empty string to a non-empty string
        // requires
        // as many insertions as the length of the non-empty string
        for (int j = 1; j <= n; ++j) {
            f[0][j] = j;
        }

        // Initialize the base case: transforming a non-empty string to an empty string
        // requires
        // as many deletions as the length of the non-empty string
        for (int i = 1; i <= m; ++i) {
            f[i][0] = i;

            // Fill in the rest of the table using dynamic programming
            for (int j = 1; j <= n; ++j) {
                // If the current characters in word1 and word2 are the same, no operation is
                // needed
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    // Otherwise, consider all possible operations (insertion, deletion,
                    // substitution)
                    // and choose the one with the minimum cost
                    f[i][j] = Math.min(f[i - 1][j], Math.min(f[i][j - 1], f[i - 1][j - 1])) + 1;
                }
            }
        }

        // The minimum edit distance is stored in the bottom-right corner of the table
        return f[m][n];
    }
}
