/*
 HackerRank Interview Preparation Kit - Minimum Swaps 2

 Given an initially zeroed array of size n, you perform m operations. 
 Each operation specifies three integers a, b, and k, which means you should add k to all 
 elements from index a to index b (inclusive). After all operations, 
 you need to find the maximum value in the array.

 Example 1:
 Input: n = 5, m = 3, queries = [[1, 3, 2], [2, 4, 3], [3, 5, 4]]
 Output: 5
 
 Example 2:
 Input: n = 5, m = 3, queries = [[1, 3, 2], [2, 4, 3], [3, 5, 4]]
 Output: 5
 */

import java.util.Scanner;

class Solution {
    static long arrayManipulation(int n, int[][] queries) {
        // Initialize the array with zeros
        long[] arr = new long[n];

        // Apply each operation directly to the array
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0]; // Start index (1-based)
            int b = queries[i][1]; // End index (1-based)
            long k = queries[i][2]; // Value to add

            // Perform the operation
            for (int j = a - 1; j < b; j++) { // Convert to 0-based index
                arr[j] += k;
            }
        }

        // Find the maximum value in the array
        long max = 0;
        for (long value : arr) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Size of the array
        int m = scanner.nextInt(); // Number of operations

        int[][] queries = new int[m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                queries[i][j] = scanner.nextInt();
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);
        scanner.close();
    }
}