/*
 * Take Gifts From the Richest Pile - 2558
 */

 import java.util.PriorityQueue;

public class Solution {

    /**
     * Picks gifts by processing the top k elements with the highest values,
     * replacing each with their square root,
     * then sums up the values left in the gifts array.
     * 
     * @param gifts An array of integers representing gift values.
     * @param k     The number of times to pick the gift with the highest value and
     *              replace it with its square root.
     * @return The sum of the final values of the gifts.
     */
    public long pickGifts(int[] gifts, int k) {
        // Create a max-heap priority queue to store the gifts, such that the largest
        // value is always at the top.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all the gifts into the max-heap.
        for (int value : gifts) {
            maxHeap.offer(value);
        }

        // Process the top k elements by replacing each with the integer part of its
        // square root.
        while (k-- > 0 && !maxHeap.isEmpty()) {
            int highestValue = maxHeap.poll(); // Retrieve and remove the gift with the highest value.
            maxHeap.offer((int) Math.sqrt(highestValue)); // Replace it with its square root and reinsert into the
                                                          // queue.
        }

        // Calculate the sum of the final values of the gifts.
        long totalValue = 0;
        for (int value : maxHeap) {
            totalValue += value;
        }

        // Return the total sum of values.
        return totalValue;
    }
}
