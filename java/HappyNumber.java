/*
 Happy Number

1. Start with any positive integer.
2. Replace the number with the sum of the squares of its digits.
3. Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle that does not include 1.
4. A number is happy if it eventually reaches 1.

Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

Input: n = 2
Output: false
 */

class Solution {

    // Method to determine if a number is a happy number.
    public boolean isHappy(int n) {
        // Initialize slow and fast pointers to detect cycle.
        int slowRunner = n;
        int fastRunner = getNext(n);

        // Loop until the two pointers meet or we find a happy number.
        while (slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner); // Move slow pointer by one step.
            fastRunner = getNext(getNext(fastRunner)); // Move fast pointer by two steps.
        }

        // If the slow runner reaches 1, then the number is happy.
        // If the pointers meet and it's not at 1, then a cycle is detected and the number is not happy.
        return slowRunner == 1;
    }

    // Helper method to calculate the next number in the sequence.
    private int getNext(int number) {
        int sumOfSquares = 0;
        while (number > 0) {
            int digit = number % 10; // Extract the last digit of the current number.
            sumOfSquares += digit * digit; // Add the square of the extracted digit to the sum.
            number /= 10; // Remove the last digit from the current number.
        }
        return sumOfSquares;
    }
}

