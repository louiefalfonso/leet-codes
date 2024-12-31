/*
 * Palindromic Substrings - 647
 */

 class Solution {
    
    public int countSubstrings(String s) {
        // Initialize the count of palindromic substrings to 0
        int ans = 0;

        // Get the length of the input string
        int n = s.length();

        // Iterate over the possible centers of palindromic substrings
        // Use k to represent the center, where k ranges from 0 to 2n - 2
        // This is because a palindromic substring can be centered at a character or
        // between two characters
        for (int k = 0; k < n * 2 - 1; ++k) {
            // Calculate the start and end indices of the potential palindromic substring
            // i is the start index, and j is the end index
            int i = k / 2, j = (k + 1) / 2;

            // Expand outwards from the center to find the longest palindromic substring
            while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
                // If the characters at the start and end indices match, increment the count of
                // palindromic substrings
                ++ans;

                // Move the start index to the left and the end index to the right
                --i;
                ++j;
            }
        }

        // Return the total count of palindromic substrings
        return ans;
    }
}
