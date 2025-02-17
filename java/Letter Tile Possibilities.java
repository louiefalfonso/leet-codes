// Letter Tile Possibilities - 1079

class Solution {
    
    // Returns the number of possible tile combinations
    public int numTilePossibilities(String tiles) {
        // Create an array to store the count of each letter
        int[] cnt = new int[26];
        // Count the occurrences of each letter in the input string
        for (char c : tiles.toCharArray()) {
            ++cnt[c - 'A']; // 'A' is subtracted to map 'A' to index 0, 'B' to index 1, etc.
        }
        // Start the depth-first search to find all possible combinations
        return dfs(cnt);
    }

    // Depth-first search function to find all possible combinations
    private int dfs(int[] cnt) {
        // Initialize the result count
        int res = 0;
        // Iterate over all letters
        for (int i = 0; i < cnt.length; ++i) {
            // If the current letter has not been used up
            if (cnt[i] > 0) {
                // Increment the result count (for the current letter)
                ++res;
                // Decrement the count of the current letter
                --cnt[i];
                // Recursively search for combinations using the remaining letters
                res += dfs(cnt);
                // Backtrack and restore the count of the current letter
                ++cnt[i];
            }
        }
        // Return the total count of possible combinations
        return res;
    }
}