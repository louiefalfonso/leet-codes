/*
 * The kth Factor of n - 1492
 */

 class Solution {
    public int kthFactor(int n, int k) {
        // Iterate through all factors of n
        for (int i = 1; i <= n; i++) {
            // Check if the current factor is a factor of n
            // If it is, decrement k
            if (n % i == 0) {
                // Decrement k
                k--;
                // If k becomes 0, return the current factor
                if (k == 0) {
                    // Return the current factor
                    return i;
                }
            }
        }

        // If k is not found, return -1
        return -1;
    }
}