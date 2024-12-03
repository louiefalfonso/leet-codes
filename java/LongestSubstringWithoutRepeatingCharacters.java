/*
 Longest Substring Without Repeating Characters
 
 Given a string s, find the length of the longest substring without repeating
 characters.Given a string s, find the length of the longest substring without
 duplicate characters.
 
 A substring is a contiguous sequence of characters within a string.

 Example 1:
 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
 
 Example 2:
 Input: s = "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.
 
 */

 class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0; // Variable to store the maximum length of substring found

        // Check all possible substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j); // Get the current substring
                if (hasUniqueCharacters(substring)) { // Check if it has all unique characters
                    maxLength = Math.max(maxLength, substring.length()); // Update maxLength
                }
            }
        }

        return maxLength; // Return the maximum length found
    }

    // to check if a string has all unique characters
    private boolean hasUniqueCharacters(String str) {
        boolean[] charSet = new boolean[128]; // Assuming ASCII characters
        for (char c : str.toCharArray()) {
            if (charSet[c]) { // If character is already seen
                return false; // Not unique
            }
            charSet[c] = true; // Mark character as seen
        }
        return true; // All characters are unique
    }

}
