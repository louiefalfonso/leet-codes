// Detect Squares - 2013

import java.util.HashMap;
import java.util.Map;

class DetectSquares {
    // Map to store point counts, where each key is an x-coordinate and each value is another map
    // with y-coordinates as keys and point counts as values
    private Map<Integer, Map<Integer, Integer>> cnt = new HashMap<>();

    public DetectSquares() {
    }

    // Add a point to the count map
    public void add(int[] point) {
        int x = point[0], y = point[1];
        // Use computeIfAbsent to create a new inner map for x if it doesn't exist
        cnt.computeIfAbsent(x, k -> new HashMap<>())
                // Use merge to increment the count for y, or set it to 1 if it doesn't exist
                .merge(y, 1, Integer::sum);
    }

    // Count the number of squares that can be formed with the given point
    public int count(int[] point) {
        int x1 = point[0], y1 = point[1];
        // If there are no points with the same x-coordinate, return 0
        if (!cnt.containsKey(x1)) {
            return 0;
        }
        int ans = 0;
        // Iterate over all x-coordinates in the count map
        for (var e : cnt.entrySet()) {
            int x2 = e.getKey();
            // Skip the case where x2 is the same as x1
            if (x2 != x1) {
                // Calculate the distance between x1 and x2
                int d = x2 - x1;
                // Get the inner maps for x1 and x2
                var cnt1 = cnt.get(x1);
                var cnt2 = e.getValue();
                // Count the number of squares that can be formed with the given point and the
                // points in cnt2
                // There are two possible squares: one with y1 + d and one with y1 - d
                ans += cnt2.getOrDefault(y1, 0) * cnt1.getOrDefault(y1 + d, 0) * cnt2.getOrDefault(y1 + d, 0);
                ans += cnt2.getOrDefault(y1, 0) * cnt1.getOrDefault(y1 - d, 0) * cnt2.getOrDefault(y1 - d, 0);
            }
        }
        return ans;
    }
}
