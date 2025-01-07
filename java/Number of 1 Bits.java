// Number of 1 Bits - 191

public class Solution {

    public int hammingWeight(int n) {
        int onesCount = 0; // Store the count of 1-bits encountered

        // Use '!=0' in the condition to ensure we process all bits of n.
        // Since Java does not support unsigned int natively, we interpret n as unsigned by comparing directly to 0.
        while (n != 0) {
            // Apply the bit manipulation trick n & (n - 1) which clears the least significant 1-bit in n.
            n &= n - 1;

            // Increment the count of 1-bits for every 1-bit cleared by the operation above.
            ++onesCount;
        }

        return onesCount; // Return the total count of 1-bits found
    }
}