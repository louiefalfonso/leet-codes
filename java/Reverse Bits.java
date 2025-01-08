// Reverse Bits - 190

public class Solution {

    public int reverseBits(int number) {
        // Initialize result to zero to start with a clean slate of bits
        int result = 0;

        // Loop over all the 32 bits of an integer
        // The loop continues while there are non-zero bits remaining
        for (int i = 0; i < 32 && number != 0; i++) {
            // Using bitwise OR and shift to add the least significant bit of 'number' to the result
            // (1) number & 1 isolates the least significant bit of 'number'
            // (2) << (31 - i) moves the bit to its reversed position
            // (3) |= assigns the bit to the correct position in result
            result |= ((number & 1) << (31 - i));

            // Unsigned right shift the 'number' by one to process the next bit in the next iteration
            number >>>= 1;
        }

        // Return the reversed bits integer
        return result;
    }
}
