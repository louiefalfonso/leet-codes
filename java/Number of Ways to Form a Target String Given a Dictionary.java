/*
 * Number of Ways to Form a Target String Given a Dictionary -1639
 */

 class Solution {
    private int targetLength; // Length of the target string
    private int wordLength; // Length of the words
    private String target; // The target string
    private Integer[][] memo; // Memoization array
    private int[][] charCount; // Counts of each character at each position across all words
    private final int MOD = (int) 1e9 + 7; // The modulus value for avoiding overflow

    public int numWays(String[] words, String target) {
        targetLength = target.length();
        wordLength = words[0].length();
        memo = new Integer[targetLength][wordLength];
        this.target = target;
        charCount = new int[wordLength][26]; // 26 for 'a' to 'z'

        // Count the occurrence of each character in each column
        for (String word : words) {
            for (int j = 0; j < wordLength; ++j) {
                charCount[j][word.charAt(j) - 'a']++;
            }
        }

        // Start the depth-first search from the first character of target
        // and first character position in words
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        // If we have matched all characters of target return 1 way to match
        if (i >= targetLength) {
            return 1;
        }
        // If we run out of positions in words before matching target, return 0 ways
        if (j >= wordLength) {
            return 0;
        }
        // If we have already computed this state, return its value
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        // Case 1: Skip the current position in words and move to the next
        long ans = dfs(i, j + 1);

        // Case 2: Use the current position in words if it matches the current character
        // in target
        ans += (long) dfs(i + 1, j + 1) * charCount[j][target.charAt(i) - 'a'];

        // Modulus operation to avoid integer overflow
        ans %= MOD;

        // Save and return the computed value
        return memo[i][j] = (int) ans;
    }
}