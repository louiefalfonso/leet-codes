/*
Reverse Vowels of a String - 345

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both
lower and upper cases, more than once.

Example 1:
Input: s = "hello"
Output: "holle"

Example 2:
Input: s = "leetcode"
Output: "leotcede"

 */

 class Solution {
    public String reverseVowels(String s) {

        // Create an array to flag vowels. The ASCII value of the character will serve as the index.
        boolean[] isVowel = new boolean[128];

        // Populate the isVowel array with true for all vowel characters, both uppercase
        // and lowercase.
        for (char c : "aeiouAEIOU".toCharArray()) {
            isVowel[c] = true;
        }

        // Convert the input string to a character array for easy manipulation.
        char[] characters = s.toCharArray();

        // Initialize two pointers, one at the start (i) and one at the end (j) of the character array.
        int i = 0, j = characters.length - 1;

        // Use a while loop to traverse the character array from both ends until they meet or cross.
        while (i < j) {
            // Move the start pointer forward if the current character is not a vowel.
            while (i < j && !isVowel[characters[i]]) {
                ++i;
            }
            // Move the end pointer backward if the current character is not a vowel.
            while (i < j && !isVowel[characters[j]]) {
                --j;
            }
            // Check if the pointers haven't crossed; swap the vowels if needed.
            if (i < j) {
                char temp = characters[i];
                characters[i] = characters[j];
                characters[j] = temp;

                // After swapping, move both pointers to continue to the next characters.
                ++i;
                --j;
            }
        }

        // Convert the character array back into a string and return it.
        return String.valueOf(characters);
    }
}