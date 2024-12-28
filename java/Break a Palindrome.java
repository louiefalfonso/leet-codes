/*
 * Break a Palindrome - 1328
 */

 class Solution {
    public String breakPalindrome(String palindrome) {
        // Get the length of the palindrome string.
        int length = palindrome.length();

        // If the string is only one character, we cannot make it non-palindrome by
        // changing any letter.
        if (length == 1) {
            return "";
        }

        // Convert the string into a character array for manipulation.
        char[] charArray = palindrome.toCharArray();

        // initialize an index variable to iterate over the first half of the string.
        int index = 0;

        // Iterate over the first half of the palindrome.
        // We only need to check the first half since the second half is a mirror of the
        // first.
        while (index < length / 2 && charArray[index] == 'a') {
            // Move to the next character if the current character is 'a'.
            ++index;
        }

        // If we've reached the middle without finding a character that is not 'a',
        // then all characters must be 'a'. In this case, change the last character to
        // 'b'.
        if (index == length / 2) {
            charArray[length - 1] = 'b';
        } else {
            // Otherwise, we found a non-'a' character in the first half,
            // change it to 'a' to break the palindrome.
            charArray[index] = 'a';
        }

        // Convert the character array back to a string and return the result.
        return new String(charArray);
    }
}
