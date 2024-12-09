/*
 * Number of Recent Calls - 933
 */

 import java.util.Deque;
import java.util.ArrayDeque;

class RecentCounter {
    // Queue to store the timestamps of the pings.
    private Deque<Integer> queue = new ArrayDeque<>();

    /**
     * Constructor initializes the RecentCounter with an empty queue.
     */
    public RecentCounter() {
    }

    /**
     * Records a new ping, and returns the number of pings in the last 3000
     * milliseconds.
     *
     * @param t The timestamp of the ping.
     * @return The count of pings in the last 3000 milliseconds.
     */
    public int ping(int t) {
        // Note: Timestamp here is assumed to be in milliseconds.

        // Offer/add the new ping's timestamp to the end of the queue.
        queue.offer(t);

        // Continue removing(polling) pings from the start of the queue if they are older
        // than 3000 milliseconds compared to the current ping's timestamp.
        while (!queue.isEmpty() && queue.peekFirst() < t - 3000) {
            queue.pollFirst();
        }

        // After removing old pings, return the size of the queue,
        // which is the count of recent pings.
        return queue.size();
    }
}