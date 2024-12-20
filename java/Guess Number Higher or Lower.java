/*
 * Guess Number Higher or Lower - 374
 */

 public class Solution extends GuessGame {
    
    public int guessNumber(int n) {
        // Initialize the lower bound of the search range.
        int left = 1;
        // Initialize the upper bound of the search range.
        int right = n;

        // Continue searching as long as the range has not been narrowed down to a
        // single element.
        while (left < right) {
            // Calculate the midpoint of the current range to use as our guess.
            int mid = left + (right - left) / 2;

            // Make a guess using the midpoint and get the response from the guess API.
            int apiResponse = guess(mid);

            // If the guess is too high or correct, narrow the range to the lower half
            // (inclusive of mid).
            if (apiResponse <= 0) {
                right = mid;
            } else {
                // If the guess is too low, narrow the range to the upper half (exclusive of
                // mid).
                left = mid + 1;
            }
        }
        // When the loop exits, left and right converge to the target number; return it.
        return left;
    }
}
