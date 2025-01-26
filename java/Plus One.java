// Plus One - 66

class Solution {
    public int[] plusOne(int[] digits) {
        // Get the number of digits in the array
        int length = digits.length;

        // Iterate over the digits starting from the least significant digit (LSD)
        for (int i = length - 1; i >= 0; --i) {
            // Increase the current digit by one
            digits[i]++;

            // If after the increment the digit is 10, it means it should be 0, and we carry
            // over 1.
            // But if it's not 10 after the increment, we can return the result immediately.
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }

        // If we're here, it means that we had a carry out from the most significant
        // digit (MSD)
        // which requires us to expand the array. Example: 999 + 1 = 1000
        int[] result = new int[length + 1];
        result[0] = 1; // Set the first element to 1, the rest are default to 0

        // Return the result which has an additional digit
        return result;
    }
}