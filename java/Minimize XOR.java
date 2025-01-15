// Minimize XOR - 2429

class Solution {
    public int minimizeXor(int num1, int num2) {
        // Count the number of 1-bits (set bits) in both num1 and num2
        int count1 = Integer.bitCount(num1);
        int count2 = Integer.bitCount(num2);

        // If count1 is greater than count2, we need to turn off some 1-bits in num1
        while (count1 > count2) {
            // Turn off (unset) the rightmost 1-bit in num1
            num1 &= (num1 - 1);
            // Decrement count1 as we have reduced the number of 1-bits by one
            --count1;
        }

        // If count1 is less than count2, we need to turn on (set) additional 1-bits in
        // num1
        while (count1 < count2) {
            // Turn on (set) the rightmost 0-bit in num1
            num1 |= (num1 + 1);
            // Increment count1 as we have increased the number of 1-bits by one
            ++count1;
        }

        // After the adjustments, num1 should have the same number of 1-bits as num2,
        // and this is the minimized XOR value we are looking for
        return num1;
    }
}