// Find the Punishment Number of an Integer - 2698

class Solution {
    
    //Calculates the sum of squares of numbers from 1 to n, where the square of each number is a palindrome.
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            int x = i * i;
            // Check if the square of the number is a palindrome
            if (check(x + "", 0, i)) {
                ans += x;
            }
        }
        return ans;
    }

    //Checks if a number is a palindrome.
    private boolean check(String s, int i, int x) {
        int m = s.length();
        // Base case: if the substring is empty, return true if x is 0
        if (i >= m) {
            return x == 0;
        }
        int y = 0;
        // Iterate over the substring and check if the sum of the digits is equal to x
        for (int j = i; j < m; ++j) {
            y = y * 10 + (s.charAt(j) - '0');
            // If the sum of the digits is greater than x, break the loop
            if (y > x) {
                break;
            }
            // Recursively check if the substring starting from the next digit is a
            // palindrome
            if (check(s, j + 1, x - y)) {
                return true;
            }
        }
        return false;
    }
}