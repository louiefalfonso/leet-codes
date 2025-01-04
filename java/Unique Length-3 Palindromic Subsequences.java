/*
 * Unique Length-3 Palindromic Subsequences - 1930
 */

 import java.util.HashSet;
 import java.util.Set;

 
 class Solution {
    // Method to count the unique palindromic subsequences in the given string
    public int countPalindromicSubsequence(String s) {
        // Initialize the count of unique palindromic subsequences to 0
        int count = 0;

        // Iterate through all lowercase alphabets
        for (char currentChar = 'a'; currentChar <= 'z'; ++currentChar) {
            // Find the first and last occurrence of 'currentChar' in the string
            int leftIndex = s.indexOf(currentChar);
            int rightIndex = s.lastIndexOf(currentChar);

            // Create a HashSet to store unique characters between the first and
            // last occurrence of 'currentChar'
            Set<Character> uniqueChars = new HashSet<>();

            // Iterate over the substring that lies between the first and
            // last occurrence of 'currentChar'
            for (int i = leftIndex + 1; i < rightIndex; ++i) {
                // Add each character in the substring to the HashSet
                uniqueChars.add(s.charAt(i));
            }

            // The number of unique characters added to the HashSet is the number
            // of palindromic subsequences starting and ending with 'currentChar'
            count += uniqueChars.size();
        }

        // Return the total count of unique palindromic subsequences
        return count;
    }
}