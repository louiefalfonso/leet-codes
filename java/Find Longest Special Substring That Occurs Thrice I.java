/*
 * Find Longest Special Substring That Occurs Thrice I - 2981
 */

 class Solution {
    private String inputString;
    private int stringLength;

    // Method to find the maximum length of substring satisfying specific criteria
    public int maximumLength(String inputString) {
        this.inputString = inputString;
        this.stringLength = inputString.length();

        int left = 0, right = stringLength;

        // Binary search to find the maximum substring length
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (isCriteriaSatisfied(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        // If unable to find such a length, return -1. Otherwise, return the length
        // found.
        return left == 0 ? -1 : left;
    }

    // Helper method to check if a specific length satisfies the criteria
    private boolean isCriteriaSatisfied(int targetLength) {
        int[] frequencyCounter = new int[26];

        // Iterate over the string to check the frequency of each character
        for (int i = 0; i < stringLength;) {
            // Find the end index of the current character sequence
            int endIndex = i + 1;
            while (endIndex < stringLength && inputString.charAt(endIndex) == inputString.charAt(i)) {
                endIndex++;
            }

            // Calculate the character's index in the alphabet
            int charIndex = inputString.charAt(i) - 'a';

            // Update the frequency counter for each character based on the criteria
            frequencyCounter[charIndex] += Math.max(0, endIndex - i - targetLength + 1);

            // If any character occurs >= 3 times after removing `targetLength` elements,
            // return true
            if (frequencyCounter[charIndex] >= 3) {
                return true;
            }

            // Move to the next different character
            i = endIndex;
        }

        // If no character meets the criteria, return false
        return false;
    }
}
