// Pow(x, n) - 50

class Solution {
    
    //Returns x to the power of n.
    public double myPow(double x, int n) {
        // If n is non-negative, calculate the power directly
        // If n is negative, calculate the power of the reciprocal
        return n >= 0 ? qpow(x, n) : 1 / qpow(x, -(long) n);
    }

    // Helper function to calculate a to the power of n using exponentiation by squaring.
    private double qpow(double a, long n) {
        double ans = 1; // Initialize the result to 1
        for (; n > 0; n >>= 1) { // Loop until n becomes 0
            if ((n & 1) == 1) { // If n is odd, multiply the result by a
                ans = ans * a;
            }
            a = a * a; // Square a for the next iteration
        }
        return ans; // Return the final result
    }
}