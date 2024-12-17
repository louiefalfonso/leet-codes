/*
 * Construct String With Repeat Limit - 2182
 */

 class Solution {

    public String repeatLimitedString(String s, int repeatLimit) {
        // Array to hold the count of each letter in the string
        int[] letterCount = new int[26];

        // Counting the occurrences of each character in the string
        for (char ch : s.toCharArray()) {
            letterCount[ch - 'a']++;
        }

        // StringBuilder to build the result string
        StringBuilder result = new StringBuilder();

        // Iterate from the letter 'z' to 'a'
        for (int i = 25; i >= 0; --i) {
            // Pointer to check for the next available smaller character
            int nextCharIndex = i - 1;

            while (true) {
                // Append the current character up to repeatLimit times
                for (int k = Math.min(repeatLimit, letterCount[i]); k > 0; --k) {
                    letterCount[i]--; // Decrement the count of the current character
                    result.append((char) ('a' + i)); // Add the current character to the result
                }

                // If all occurrences of the current character have been used up, break out of
                // the loop
                if (letterCount[i] == 0) {
                    break;
                }

                // Find the next available character which has at least one occurrence left
                while (nextCharIndex >= 0 && letterCount[nextCharIndex] == 0) {
                    --nextCharIndex;
                }

                // If there are no more characters left to use, break out of the loop
                if (nextCharIndex < 0) {
                    break;
                }

                // Append the next available character
                letterCount[nextCharIndex]--;
                result.append((char) ('a' + nextCharIndex));
            }
        }

        // Return the result as a string
        return result.toString();
    }
}