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

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (isHappy(number)) {
            System.out.println(number + " is a happy number.");
        } else {
            System.out.println(number + " is not a happy number.");
        }

        scanner.close();
    }

    private static boolean isHappy(int n) {
        Set<Integer> seenNumbers = new HashSet<>();

        while (n != 1 && !seenNumbers.contains(n)) {
            seenNumbers.add(n);
            n = sumOfSquares(n);
        }

        return n == 1; // If we end with 1, it's a happy number
    }

    private static int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10; // Get the last digit
            sum += digit * digit; // Square it and add to sum
            num /= 10; // Remove the last digit
        }
        return sum;
    }
}