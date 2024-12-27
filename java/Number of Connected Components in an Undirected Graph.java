/*
 * Number of Connected Components in an Undirected Graph - 323
 */

 class Solution {
    private int[] parent; // This array will hold the parent for each node representing the components

    public int countComponents(int n, int[][] edges) {
        // Initialize parent array, where initially each node is its own parent
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }

        // For each edge, perform a union of the two vertices
        for (int[] edge : edges) {
            int vertex1 = edge[0], vertex2 = edge[1];
            union(vertex1, vertex2);
        }

        // Count the number of components by counting the nodes that are their own
        // parents
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (i == find(i)) { // If the node's parent is itself, it's the root of a component
                count++;
            }
        }
        return count; // Return the total count of connected components
    }

    // Find function with path compression
    private int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path compression for efficiency
        }
        return parent[node]; // Return the root parent of the node
    }

    // Union function to join two subsets into a single subset
    private void union(int node1, int node2) {
        int root1 = find(node1); // Find the root parent of the first node
        int root2 = find(node2); // Find the root parent of the second node
        parent[root1] = root2; /* Make one root parent the parent of the other */
    }
}