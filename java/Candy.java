// Candy - 135

import java.util.Arrays;

class Solution {
    
    public int candy(int[] ratings) {
        // Get the number of children
        int n = ratings.length;

        // Initialize an array to store the number of candies for each child
        int[] candies = new int[n];

        // Initialize each child with 1 candy
        Arrays.fill(candies, 1);

        // First pass: ensure that a child with a higher rating than the previous child
        // gets more candies
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                // Give the current child one more candy than the previous child
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Second pass: ensure that a child with a higher rating than the next child
        // gets more candies
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // Give the current child the maximum of its current candies and one more than
                // the next child's candies
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Return the total number of candies
        return Arrays.stream(candies).sum();
    }
}