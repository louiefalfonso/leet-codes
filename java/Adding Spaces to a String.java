/*
 * Adding Spaces to a String - 2109
 * 
 You are given a 0-indexed string s and a 0-indexed integer array spaces that describes the indices 
 in the original string where spaces will be added. Each space should be inserted before the character 
 at the given index.
 Return the modified string after the spaces have been added.
 
 Example 1:

Input: s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
Output: "Leetcode Helps Me Learn"
Explanation: 
The indices 8, 13, and 15 correspond to the underlined characters in "LeetcodeHelpsMeLearn".
We then place spaces before those characters.
 */

 class Solution {
    // Method that adds spaces into a string at specified indices.
    public String addSpaces(String s, int[] spaces) {
        // StringBuilder is used for efficient string manipulation
        StringBuilder result = new StringBuilder();

        // Use two pointers: 'i' for string 's', and 'j' for the spaces array
        for (int i = 0, j = 0; i < s.length(); ++i) {
            // Check if we have more spaces to add and if the current position matches the next space position
            if (j < spaces.length && i == spaces[j]) {
                // If so, append a space to the result
                result.append(' ');
                // Move to the next position in the spaces array
                ++j;
            }
            // Append the current character from string 's'
            result.append(s.charAt(i));
        }

        // Return the modified string with spaces added
        return result.toString();
    }
}
