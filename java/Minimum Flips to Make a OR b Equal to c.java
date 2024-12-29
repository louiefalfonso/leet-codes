/*
 * Minimum Flips to Make a OR b Equal to c - 1318
 */

 class Solution {

    // This method calculates the minimum number of flips required to make
    // bitwise OR of 'a' and 'b' equal to 'c'.
    public int minFlips(int a, int b, int c) {
        // Initialize the variable to store the count of minimum flips.
        int minFlipsCount = 0;

        // Iterate over each bit position from 0 to 29 (30 bits in total assuming 32-bit
        // integers)
        // to compare the bits in 'a', 'b', and 'c'.
        for (int i = 0; i < 30; ++i) {
            // Extract the i-th bit from 'a', 'b', and 'c'.
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            // Check if the result of 'bitA | bitB' doesn't match 'bitC'.
            if ((bitA | bitB) != bitC) {
                // If both bits in 'a' and 'b' are 1, and 'c' is 0, we need 2 flips.
                // Otherwise, we need just 1 flip (either from 'a' or 'b', or to match a 1 in
                // 'c').
                minFlipsCount += (bitA == 1 && bitB == 1) ? 2 : 1;
            }
        }

        // Return the total count of flips required.
        return minFlipsCount;
    }
}
