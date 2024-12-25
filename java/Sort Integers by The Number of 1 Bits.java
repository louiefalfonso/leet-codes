/*
  Sort Integers by The Number of 1 Bits - 1356
 */

 import java.util.Arrays;

class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length; // Store the length of the array

        // Add to each element in the array a value that represents
        // the bit count of the number multiplied by 100000 to ensure
        // it is prioritized in the sorting
        for (int i = 0; i < n; ++i) {
            int bitCount = Integer.bitCount(arr[i]); // Count number of 1-bits in arr[i]
            arr[i] += bitCount * 100000; // Add 100000 for each 1-bit to prioritize in sorting
        }

        Arrays.sort(arr); // Sort the array with modified values

        // After sorting retrieve the original values by taking modulo 100000
        for (int i = 0; i < n; ++i) {
            arr[i] %= 100000; // Reduce each element back to original value
        }

        return arr; // Return the sorted array by bits
    }
}