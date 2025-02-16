// String to Integer (atoi) - 8

class Solution {
    
    //Converts a string to a 32-bit signed integer.
    public int myAtoi(String s) {
        
        // Check for null input
        if (s == null)
            return 0;

        // Get the length of the input string
        int n = s.length();

        // If the string is empty, return 0
        if (n == 0)
            return 0;

        // Initialize index to start scanning the string
        int i = 0;

        // Skip leading whitespace characters
        while (s.charAt(i) == ' ') {
            // If we reach the end of the string, return 0
            if (++i == n)
                return 0;
        }

        // Determine the sign of the number
        int sign = 1;
        if (s.charAt(i) == '-')
            sign = -1;

        // Skip the sign character if present
        if (s.charAt(i) == '-' || s.charAt(i) == '+')
            ++i;

        // Initialize result and overflow check variables
        int res = 0, flag = Integer.MAX_VALUE / 10;

        // Scan the string for digits
        for (; i < n; ++i) {
            // If a non-digit character is encountered, break the loop
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                break;

            // Check for overflow
            if (res > flag || (res == flag && s.charAt(i) > '7'))
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            // Update the result
            res = res * 10 + (s.charAt(i) - '0');
        }

        // Return the final result with the correct sign
        return sign * res;
    }
}