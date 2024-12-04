/*
 Merge Strings Alternately - 1768

 You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, 
 starting with word1. If a string is longer than the other, append the additional letters onto the 
 end of the merged string.

Return the merged string.

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
 */

 class Solution {
    
    // Method to merge two strings alternately.
    public String mergeAlternately(String word1, String word2) {

        // Length of the first and second words
        int lengthWord1 = word1.length(), lengthWord2 = word2.length();

        // StringBuilder to create the result string efficiently
        StringBuilder mergedString = new StringBuilder();

        // Iterate as long as we have characters remaining in at least one string
        for (int index = 0; index < lengthWord1 || index < lengthWord2; ++index) {
            // If the current index is within the bounds of word1, append its character
            if (index < lengthWord1) {
                mergedString.append(word1.charAt(index));
            }
            // If the current index is within the bounds of word2, append its character
            if (index < lengthWord2) {
                mergedString.append(word2.charAt(index));
            }
        }
        // Return the resulting string
        return mergedString.toString();
    }
}