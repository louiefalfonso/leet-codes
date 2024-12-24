/*
 * N-th Tribonacci Number - 1137
 */


class Solution {
    // Method to calculate the nth Tribonacci number
    public int tribonacci(int n) {
        // Initialize the first three Tribonacci numbers
        int a = 0; // T0 = 0
        int b = 1; // T1 = 1
        int c = 1; // T2 = 1

        // Loop until we reach the desired Tribonacci number
        while (n-- > 0) {
            // Calculate the next Tribonacci number as the sum of the previous three
            int d = a + b + c; // Tn = T(n-1) + T(n-2) + T(n-3)

            // Update the values of a, b, and c for the next iteration
            a = b; // Shift T(n-2) to T(n-3)
            b = c; // Shift T(n-1) to T(n-2)
            c = d; // Update T(n) to the newly calculated value
        }

        // Return the nth Tribonacci number
        return a; // Tn is now stored in a
    }
}