/*
 
Make String a Subsequence Using Cyclic Increments - 2825

You are given two 0-indexed strings str1 and str2.

In an operation, you select a set of indices in str1, and for each index i in the set, 
increment str1[i] to the next character cyclically. That is 'a' becomes 'b', 'b' becomes 'c', 
and so on, and 'z' becomes 'a'.

Return true if it is possible to make str2 a subsequence of str1 by performing the operation 
at most once, and false otherwise.

Note: A subsequence of a string is a new string that is formed from the original 
string by deleting some (possibly none) of the characters without disturbing the 
relative positions of the remaining characters.

Example 1:
Input: str1 = "abc", str2 = "ac"
Output: true
Explanation: In one operation, we can increment 'b' to 'c'.

Example 2:
Input: str1 = "abc", str2 = "cab"
Output: false
Explanation: It is impossible to make "cab" a subsequence of "abc".
 */

class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int currentIndex = 0; // Pointer into str2 to track our current progress.
        int lengthOfStr2 = str2.length(); // Total length of str2.

        // Iterate through each character of str1.
        for (char currentChar : str1.toCharArray()) {
            
            // Calculate the next character in the alphabetical order ('z' wraps to 'a').
            char nextChar = currentChar == 'z' ? 'a' : (char) (currentChar + 1);

            // Check if the current character in str1 matches the current or next valid
            // character in str2.
            if (currentIndex < lengthOfStr2 &&
                    (str2.charAt(currentIndex) == currentChar || str2.charAt(currentIndex) == nextChar)) {
                currentIndex++; // Move to the next character in str2.
            }
        }

        // str2 is a subsequence of str1 only if we have traversed its entire length.
        return currentIndex == lengthOfStr2;
    }
}