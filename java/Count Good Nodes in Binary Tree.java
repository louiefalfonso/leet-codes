/*
 * Count Good Nodes in Binary Tree - 1448
 */

 // Definition for a binary tree node.
class TreeNode {
    int val; // Value of the node
    TreeNode left; // Reference to the left child
    TreeNode right; // Reference to the right child

    // Constructor for a tree node with no children
    TreeNode() {
    }

    // Constructor for a tree node with a specific value
    TreeNode(int value) {
        this.val = value;
    }

    // Constructor for a tree node with a value and references to left and right
    // children
    TreeNode(int value, TreeNode leftChild, TreeNode rightChild) {
        this.val = value;
        this.left = leftChild;
        this.right = rightChild;
    }
}

class Solution {
    private int numGoodNodes = 0; // Variable to keep count of good nodes

    // Public method that starts the depth-first search and returns the number of
    // good nodes
    public int goodNodes(TreeNode root) {
        dfsHelper(root, Integer.MIN_VALUE);
        return numGoodNodes;
    }

    // Helper method that performs a depth-first search on the tree
    private void dfsHelper(TreeNode node, int maxSoFar) {
        if (node == null) {
            return; // Base case: if the node is null, return
        }
        if (maxSoFar <= node.val) {
            // If the current value is greater than or equal to the maximum value so far,
            // it is a good node, so increment the counter and update the maximum value
            numGoodNodes++;
            maxSoFar = node.val;
        }
        dfsHelper(node.left, maxSoFar); // Recursively call helper for left subtree
        dfsHelper(node.right, maxSoFar); // Recursively call helper for right subtree
    }
}