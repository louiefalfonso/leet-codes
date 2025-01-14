// Find the Prefix Common Array of Two Arrays - 2657

class Solution {

    // Function to find the prefix common element count between two arrays.
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length; // Get the length of the array, assumed to be of same length.
        int[] ans = new int[n]; // Array to store the count of common elements for each prefix.
        int[] countA = new int[n + 1]; // Array to count occurrences in A, 1-indexed.
        int[] countB = new int[n + 1]; // Array to count occurrences in B, 1-indexed.

        // Iterate over the arrays A and B simultaneously.
        for (int i = 0; i < n; ++i) {
            // Count the occurrences of each element in both arrays.
            ++countA[A[i]];
            ++countB[B[i]];

            // Calculate the number of common elements for each prefix (up to the current
            // i).
            for (int j = 1; j <= n; ++j) {
                ans[i] += Math.min(countA[j], countB[j]); // Add the minimum occurrences among both arrays.
            }
        }
        return ans; // Return the array of counts.
    }
}