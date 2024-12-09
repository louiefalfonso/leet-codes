/*
 * Minimum Suffix Flips - 1529
 */

 class Solution {
    // Function to find the minimum number of flips required to make the bulb status
    // string equal to the target.
    public int minFlips(String target) {
        // 'flips' counts the number of flips made.
        int flips = 0;

        // Iterate over each character of the target string.
        for (int i = 0; i < target.length(); ++i) {
            // Convert the current character to an integer value (0 or 1).
            int value = target.charAt(i) - '0';

            // If the current flip state is different from the current target bulb state,
            // a flip is required.
            // (flips & 1) finds the current state after an even or odd number of flips
            // The ^ (XOR) operator compares that state with the desired value (value).
            // When they are different, the result is 1 (true); otherwise, it's 0 (false).
            if (((flips & 1) ^ value) != 0) {
                // If a flip is required, increment the flip count.
                ++flips;
            }
        }

        // Return the total flips made to achieve the target state.
        return flips;
    }
}