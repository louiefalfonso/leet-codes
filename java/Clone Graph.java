/*
 * Clone Graph - 133
 */

 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// Definition for a graph node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {

    // A HashMap to keep track of all the nodes which have already been copied.
    private Map<Node, Node> visited = new HashMap<>();

    // This function returns the clone of the graph.
    public Node cloneGraph(Node node) {
        // If the input node is null, then return null.
        if (node == null) {
            return null;
        }

        // If the node has already been visited i.e., already cloned,
        // return the cloned node from the map.
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a new node with the value of the input node (clone it).
        Node cloneNode = new Node(node.val);
        // Mark this node as visited by putting into the visited map.
        visited.put(node, cloneNode);

        // Iterate over all the neighbors of the input node.
        for (Node neighbor : node.neighbors) {
            // Perform a depth-first search (DFS) for each neighbor,
            // and add the clone of the neighbor to the neighbors list
            // of the clone node.
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        // Return the cloned graph node.
        return cloneNode;
    }
}