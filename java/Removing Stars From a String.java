/*
 * Removing Stars From a String - 2390
 */

 class Solution {

    // Method to remove characters from a string that are followed by a star.
    // Each star (*) character means a backspace operation on the current string.
    public String removeStars(String s) {
        // Initialize a StringBuilder to hold the resulting characters after backspaces are applied.
        StringBuilder resultBuilder = new StringBuilder();

        // Iterate over each character in the string.
        for (int i = 0; i < s.length(); ++i) {
            // Check if the current character is a star
            if (s.charAt(i) == '*') {
                // If star, remove the preceding character from the StringBuilder if it exists
                if (resultBuilder.length() > 0) {
                    resultBuilder.deleteCharAt(resultBuilder.length() - 1);
                }
            } else {
                // If not a star, append the character to the StringBuilder
                resultBuilder.append(s.charAt(i));
            }
        }
        // Convert the StringBuilder back to a String and return it.
        return resultBuilder.toString();
    }
}