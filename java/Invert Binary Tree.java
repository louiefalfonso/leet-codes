/*
 * Invert Binary Tree - 226
 */

 // Definition for a binary tree node.
class TreeNode {
    int val; // The value contained in the node
    TreeNode left; // Reference to the left child
    TreeNode right; // Reference to the right child

    // Constructor for creating a leaf node
    TreeNode() {
    }

    // Constructor for creating a node with a specific value
    TreeNode(int val) {
        this.val = val;
    }

    // Constructor for creating a node with a specific value and left/right children
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// A solution class containing the method to invert a binary tree.
class Solution {

    // Inverts a binary tree and returns the root of the inverted tree.
    public TreeNode invertTree(TreeNode root) {
        // Start the depth-first search inversion from the root node
        depthFirstSearchInvert(root);
        // Return the new root after inversion
        return root;
    }

    // A helper method that uses Depth-First Search to invert the given binary tree
    // recursively.
    private void depthFirstSearchInvert(TreeNode node) {
        // Base case: If the current node is null, there's nothing to invert; return
        // immediately
        if (node == null) {
            return;
        }

        // Swap the left and right children of the current node
        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;

        // Recursively invert the left subtree
        depthFirstSearchInvert(node.left);
        // Recursively invert the right subtree
        depthFirstSearchInvert(node.right);
    }
}
