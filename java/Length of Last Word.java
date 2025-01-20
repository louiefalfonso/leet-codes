// Length of Last Word - 58

class Solution {
    // Method to find the length of the last word in a string.
    public int lengthOfLastWord(String s) {
        // Initialize index 'endIndex' to point to the end of the string.
        int endIndex = s.length() - 1;

        // Skip all the trailing spaces if any.
        while (endIndex >= 0 && s.charAt(endIndex) == ' ') {
            endIndex--;
        }

        // Initialize index 'startIndex' to keep track of the start of the last word.
        int startIndex = endIndex;

        // Move 'startIndex' backwards until we find a space or reach the beginning of
        // the string.
        while (startIndex >= 0 && s.charAt(startIndex) != ' ') {
            startIndex--;
        }

        // The length of the last word is the difference between 'endIndex' and
        // 'startIndex'.
        // We add 1 because 'startIndex' is either pointing to a space or one position
        // off the string.
        return endIndex - startIndex;
    }
}