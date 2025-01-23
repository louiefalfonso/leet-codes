// Kth Largest Element in a Stream - 703
import java.util.PriorityQueue;

class KthLargest {

    // Priority queue to maintain the smallest 'k' elements seen so far
    private PriorityQueue<Integer> minHeap;

    // The kth position we are interested in for the largest element
    private int k;

   
    //Constructor to initialize the data structure and populate with initial elements.
    public KthLargest(int k, int[] nums) {
        // Initialize a min-heap with the capacity to hold 'k' elements
        this.minHeap = new PriorityQueue<>(k);
        this.k = k;

        // Add the initial elements to the kth largest tracker
        for (int num : nums) {
            add(num);
        }
    }

    
    //Adds a new number into the stream and returns the kth largest element.
    public int add(int val) {
        // Always add the new value to the min-heap
        minHeap.offer(val);

        // If the size of the min-heap exceeds 'k', remove the smallest element
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // The root of the min-heap represents the kth largest element
        return minHeap.peek();
    }
}