/*
 Longest Repeating Character Replacement

 You are given a string s consisting of only uppercase english characters and an integer k. 
 You can choose up to k characters of the string and replace them with any other uppercase English character.

After performing at most k replacements, return the length of the longest substring 
which contains only one distinct character.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBA".
 */


 class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0; // Variable to store the maximum length of valid substring

        // Check all possible substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1); // Get the current substring
                if (canReplaceToSame(substring, k)) { // Check if it can be transformed
                    maxLength = Math.max(maxLength, substring.length()); // Update maxLength
                }
            }
        }

        return maxLength; // Return the maximum length found
    }

    // function to check if a substring can be transformed
    private boolean canReplaceToSame(String substring, int k) {
        int[] count = new int[26]; // Array to count occurrences of each character
        int maxCount = 0; // Variable to track the count of the most frequent character

        for (char c : substring.toCharArray()) {
            count[c - 'A']++; // Count the character
            maxCount = Math.max(maxCount, count[c - 'A']); // Update maxCount
        }

        // Calculate the number of characters that need to be replaced
        int charsToReplace = substring.length() - maxCount;

        // If we can replace at most k characters, return true
        return charsToReplace <= k;
    }

}
