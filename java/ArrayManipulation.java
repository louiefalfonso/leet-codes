/*
 HackerRank Interview Preparation Kit - Array Manipulation
 
 You are given an array of size n and m operations. Each operation consists of
 three integers a, b, and k. For each operation, you need to add k to all
 elements from index a to index b (inclusive). After all operations, you need
 to determine the maximum value in the array.
 
 */

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array and number of operations
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Create an array of size n+1 for the difference array
        long[] arr = new long[n + 1];

        // Process each operation
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt(); // Start index (1-based)
            int b = scanner.nextInt(); // End index (1-based)
            long k = scanner.nextLong(); // Value to add

            arr[a] += k; // Add k to the start index
            if (b + 1 <= n) {
                arr[b + 1] -= k; // Subtract k from the element just after the end index
            }
        }

        // Calculate the maximum value using prefix sum
        long max = 0;
        long current = 0;
        for (int i = 1; i <= n; i++) {
            current += arr[i]; // Build the actual array values from the difference array
            if (current > max) {
                max = current; // Update max if current is greater
            }
        }

        // Output the maximum value found
        System.out.println(max);
        scanner.close();
    }
}
