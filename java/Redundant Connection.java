// Redundant Connection - 684

class Solution {

    // Initialize the parent array to keep track of the connected components
    private int[] p;

  
     //Finds the redundant connection in the graph.
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        p = new int[n];

        // Initialize the parent array, where each node is its own parent
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }

        // Iterate over the edges
        for (int i = 0;; ++i) {

            // Find the parents of the two nodes in the current edge
            int pa = find(edges[i][0] - 1);
            int pb = find(edges[i][1] - 1);

            // If the parents are the same, it means we have a cycle, so return the current edge
            if (pa == pb) {
                return edges[i];
            }
            // Otherwise, union the two nodes by setting the parent of one node to the other
            p[pa] = pb;
        }
    }

    
    // Finds the parent of a node using path compression.
    private int find(int x) {
        
        // If the node is not its own parent, recursively find its parent and update the parent array
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}