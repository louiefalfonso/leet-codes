/*
 * Maximum Beauty of an Array After Applying Operation - 2779
 */

 import java.util.Arrays;

class Solution {

    public int maximumBeauty(int[] flowers, int additions) {
        // Calculate the maximum value after all possible additions.
        // We add extra space for fluctuations in the count within the k range.
        int maxValue = Arrays.stream(flowers).max().getAsInt() + additions * 2 + 2;
        int[] delta = new int[maxValue];

        // Build the difference array using the number of additions possible adding and
        // subtracting at the range ends.
        for (int flower : flowers) {
            delta[flower]++;
            delta[flower + additions * 2 + 1]--;
        }

        int maxBeauty = 0; // This will hold the maximum beauty calculated so far.
        int runningSum = 0; // This will be used to compute the running sum from the difference array.

        // Compute the running sum and find the maximum value.
        for (int value : delta) {
            runningSum += value;
            maxBeauty = Math.max(maxBeauty, runningSum);
        }

        // Return the computed maximum beauty of the bouquet.
        return maxBeauty;
    }
}