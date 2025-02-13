// K Closest Points to Origin - 973
import java.util.*;

class Solution {
    
     // Returns the k closest points to the origin (0, 0) in the 2D plane.
     
    public int[][] kClosest(int[][] points, int k) {

        // Create a max priority queue to store the points, where the point with the
        // largest distance from the origin is at the top
        // The distance from the origin is calculated as x^2 + y^2, and the point's
        // index is stored along with the distance
        PriorityQueue<int[]> maxQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // Iterate over all points
        for (int i = 0; i < points.length; ++i) {
            int x = points[i][0], y = points[i][1];
            // Calculate the distance from the origin and store it along with the point's
            // index
            maxQ.offer(new int[] { x * x + y * y, i });
            // If the queue size exceeds k, remove the point with the largest distance
            // (i.e., the top of the queue)
            if (maxQ.size() > k) {
                maxQ.poll();
            }
        }
        // Create an array to store the k closest points
        int[][] ans = new int[k][2];
        // Iterate over the queue and retrieve the k closest points
        for (int i = 0; i < k; ++i) {
            // Retrieve the point's index from the queue and use it to get the point from
            // the original array
            ans[i] = points[maxQ.poll()[1]];
        }
        // Return the k closest points
        return ans;
    }
}