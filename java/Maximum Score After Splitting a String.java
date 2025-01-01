/*
 * Maximum Score After Splitting a String - 1422
 */

 class Solution {
    public int maxScore(String s) {
        // Initialize total score for the first partition
        int totalScore = 0;
        // If the first character is '0', increase the score by 1
        if (s.charAt(0) == '0') {
            totalScore++;
        }
        // Calculate initial score for '1's in the string, skipping the first character
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                totalScore++;
            }
        }
        // The best score is initially set to the score from the initial partition
        int maxScore = totalScore;

        // Iterate through the string to find partitions and track the highest score
        for (int i = 1; i < s.length() - 1; ++i) {
            // If the current character is '0', increase the total score
            // If it is '1', decrease the total score
            totalScore += (s.charAt(i) == '0') ? 1 : -1;
            // Update the maximum score if the current total score is greater
            maxScore = Math.max(maxScore, totalScore);
        }
        // Return the highest score found amongst all possible partitions
        return maxScore;
    }
}