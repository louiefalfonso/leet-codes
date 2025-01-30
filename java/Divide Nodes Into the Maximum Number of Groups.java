// Divide Nodes Into the Maximum Number of Groups - 2493

import java.util.*;

class Solution {
    
     // This method calculates the sum of the maximum distances from each node to its
    public int magnificentSets(int n, int[][] edges) {

        // Create an adjacency list representation of the graph
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());

        // Add edges to the graph
        for (var e : edges) {
            int a = e[0] - 1, b = e[1] - 1; // adjust node indices to 0-based
            g[a].add(b);
            g[b].add(a); // since the graph is undirected
        }

        // Initialize arrays to store the maximum distance from each node to its
        // furthest node
        int[] d = new int[n];
        int[] dist = new int[n]; // temporary array to store distances during BFS

        // Iterate over each node in the graph
        for (int i = 0; i < n; ++i) {
            // Perform BFS from the current node
            Deque<Integer> q = new ArrayDeque<>();
            q.offer(i);
            Arrays.fill(dist, 0); // reset distances for the current node
            dist[i] = 1; // distance from the node to itself is 1
            int mx = 1; // maximum distance from the node to its furthest node
            int root = i; // the node with the minimum index in the current connected component

            // Perform BFS
            while (!q.isEmpty()) {
                int a = q.poll();
                root = Math.min(root, a); // update the root node
                for (int b : g[a]) {
                    if (dist[b] == 0) {
                        // if the node has not been visited yet, mark it as visited and update its
                        // distance
                        dist[b] = dist[a] + 1;
                        mx = Math.max(mx, dist[b]); // update the maximum distance
                        q.offer(b); // add the node to the queue
                    } else if (Math.abs(dist[b] - dist[a]) != 1) {
                        // if the distance between the two nodes is not 1, it means the graph contains a
                        // cycle with a length other than 1 or 2
                        return -1;
                    }
                }
            }
            // update the maximum distance for the root node
            d[root] = Math.max(d[root], mx);
        }
        // return the sum of the maximum distances from each node to its furthest node
        return Arrays.stream(d).sum();
    }
}