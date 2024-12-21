/*
 * Palindrome Number
 */ 

 class Solution {
    public boolean isPalindrome(int number) {
        // Any negative number cannot be a palindrome
        // Additionally, if the last digit is 0, the number cannot be a palindrome
        // unless the number is 0 itself.
        if (number < 0 || (number % 10 == 0 && number != 0)) {
            return false;
        }

        int reversedHalf = 0;

        // We only need to reverse half of the number to compare with the other half.
        // When the original number is less than the reversed number, it means we've
        // processed half of the digits.
        while (number > reversedHalf) {
            // Extract the last digit of the number and move it to the tens place of the
            // reversed half.
            reversedHalf = reversedHalf * 10 + number % 10;
            // Drop the last digit from the original number.
            number /= 10;
        }

        // At the end of the loop, we have two cases:
        // 1. The length of the number is odd, and we need to discard the middle digit
        // by reversedHalf / 10.
        // 2. The length of the number is even, and the reversed half should be equal to
        // the number.
        return number == reversedHalf || number == reversedHalf / 10;
    }
}
