/*
 * Lowest Common Ancestor of a Binary Search Tree - 235
 */

 // Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor to create a new node with a given value
    TreeNode(int value) {
        val = value;
    }
}

class Solution {

    // Function to find the lowest common ancestor of two nodes in a binary search tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode firstNode, TreeNode secondNode) {
        // Traverse the tree starting with the root
        while (root != null) {
            // If both nodes are greater than current node, search in right subtree
            if (root.val < Math.min(firstNode.val, secondNode.val)) {
                root = root.right; // Move to the right child
            }
            // If both nodes are less than current node, search in left subtree
            else if (root.val > Math.max(firstNode.val, secondNode.val)) {
                root = root.left; // Move to the left child
            }
            // We've found the lowest common ancestor node
            else {
                return root;
            }
        }
        // In case the while loop exits without returning (it shouldn't in proper
        // usage), return null
        return null;
    }
}
