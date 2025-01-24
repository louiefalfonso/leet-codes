// Find Eventual Safe States - 802

import java.util.List;
import java.util.ArrayList;

class Solution {
    
    // Finds all eventual safe nodes in a directed graph.
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length; // number of nodes in the graph
        int[] color = new int[n]; // color array to track node states
        List<Integer> res = new ArrayList<>(); // result list to store eventual safe nodes

        // Iterate over all nodes in the graph
        for (int i = 0; i < n; i++) {
            // If the node is eventual safe, add it to the result list
            if (dfs(i, graph, color)) {
                res.add(i);
            }
        }
        return res;
    }

    
    // Performs a depth-first search (DFS) from the given node.
    private boolean dfs(int i, int[][] graph, int[] color) {
        // If the node is already marked as eventual safe (color 2), return true
        if (color[i] == 2) {
            return true;
        }
        // If the node is currently being visited (color 1), it's part of a cycle, so
        // return false
        if (color[i] == 1) {
            return false;
        }
        // Mark the node as being visited (color 1)
        color[i] = 1;
        // Recursively visit all neighbors of the node
        for (int j = 0; j < graph[i].length; j++) {
            // If any neighbor is not eventual safe, return false
            if (!dfs(graph[i][j], graph, color)) {
                return false;
            }
        }
        // Mark the node as eventual safe (color 2)
        color[i] = 2;
        return true;
    }
}