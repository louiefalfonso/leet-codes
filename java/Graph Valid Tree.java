/*
 * Graph Valid Tree - 261
 */

 class Solution {

    private int[] parent; // The array to track the parent of each node

    // Method to determine if the input represents a valid tree
    public boolean validTree(int n, int[][] edges) {
        parent = new int[n]; // Initialize the parent array

        // Set each node's parent to itself
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }

        // Loop through all edges
        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];

            // If both nodes have the same root, there's a cycle, and it's not a valid tree
            if (find(nodeA) == find(nodeB)) {
                return false;
            }

            // Union the sets to which both nodes belong by updating the parent
            parent[find(nodeA)] = find(nodeB);

            // Decrement the number of trees - we are combining two trees into one
            --n;
        }

        // If there's exactly one tree left, the structure is a valid tree
        return n == 1;
    }

    // Method to find the root (using path compression) of the set to which x
    // belongs
    private int find(int x) {
        // If x is not the parent of itself, recursively find the root parent and apply
        // path compression
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x]; // Return the root parent of x
    }
}