/*
 * Find Minimum Diameter After Merging Two Trees - 3203
 */

 import java.util.*;
 

class Solution {
    
    // Declare private instance variables
    private List<Integer>[] g; // adjacency list representation of a graph
    private int ans; // variable to store the answer
    private int a; // variable to store the node with the maximum depth

    // Method to calculate the minimum diameter after merging two trees
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // Calculate the diameter of the first tree
        int d1 = treeDiameter(edges1);
        // Calculate the diameter of the second tree
        int d2 = treeDiameter(edges2);
        // Return the maximum diameter after merging the two trees
        return Math.max(Math.max(d1, d2), (d1 + 1) / 2 + (d2 + 1) / 2 + 1);
    }

    // Method to calculate the diameter of a tree
    public int treeDiameter(int[][] edges) {
        // Calculate the number of nodes in the tree
        int n = edges.length + 1;
        // Initialize the adjacency list representation of the graph
        g = new List[n];
        // Initialize each node in the graph with an empty list
        Arrays.setAll(g, k -> new ArrayList<>());
        // Initialize the answer variable to 0
        ans = 0;
        // Initialize the variable to store the node with the maximum depth to 0
        a = 0;
        // Iterate over each edge in the tree
        for (var e : edges) {
            // Extract the nodes connected by the edge
            int a = e[0], b = e[1];
            // Add the edge to the adjacency list representation of the graph
            g[a].add(b);
            g[b].add(a);
        }
        // Perform DFS from node 0 to find the node with the maximum depth
        dfs(0, -1, 0);
        // Perform DFS from the node with the maximum depth to find the diameter
        dfs(a, -1, 0);
        // Return the diameter of the tree
        return ans;
    }

    // Method to perform DFS from a given node
    private void dfs(int i, int fa, int t) {
        // Iterate over each neighbor of the current node
        for (int j : g[i]) {
            // Skip the parent node to avoid revisiting it
            if (j != fa) {
                // Recursively perform DFS from the neighbor node
                dfs(j, i, t + 1);
            }
        }
        // Update the answer variable if the current node has a greater depth
        if (ans < t) {
            ans = t;
            a = i;
        }
    }
}