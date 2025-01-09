// Counting Words With a Given Prefix - 2185

class Solution {

    public int prefixCount(String[] words, String pref) {
        int count = 0; // Initialize counter to track number of words with the prefix
        // Iterate through each word in the array
        for (String word : words) {
            // Check if the current word starts with the given prefix
            if (word.startsWith(pref)) {
                // Increment the count if the word has the prefix
                count++;
            }
        }
        // Return the total count of words with the prefix
        return count;
    }
}
