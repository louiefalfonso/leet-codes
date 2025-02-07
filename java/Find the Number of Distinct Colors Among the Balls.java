// Find the Number of Distinct Colors Among the Balls - 3160
import java.util.*;

class Solution {
    
     //Returns the results of the queries based on the given limit.
    public int[] queryResults(int limit, int[][] queries) {

        // Map to store the latest query for each x
        Map<Integer, Integer> g = new HashMap<>();

        // Map to store the count of each y
        Map<Integer, Integer> cnt = new HashMap<>();

        // Number of queries
        int m = queries.length;

        // Array to store the results of the queries
        int[] ans = new int[m];

        // Process each query
        for (int i = 0; i < m; ++i) {
            // Get the x and y values of the current query
            int x = queries[i][0], y = queries[i][1];

            // Increment the count of y
            cnt.merge(y, 1, Integer::sum);

            // If x already has a query and the count of its previous y becomes 0, remove it
            // from cnt
            if (g.containsKey(x) && cnt.merge(g.get(x), -1, Integer::sum) == 0) {
                cnt.remove(g.get(x));
            }

            // Update the latest query for x
            g.put(x, y);

            // Store the current size of cnt as the result of the query
            ans[i] = cnt.size();
        }

        // Return the results of the queries
        return ans;
    }
}