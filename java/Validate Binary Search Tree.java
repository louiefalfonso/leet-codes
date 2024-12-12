/*
 * Validate Binary Search Tree - 98
 */

 /**
 * Definition for a binary tree node.
 * This class represents a node of a binary tree which includes value, pointer
 * to left child
 * and pointer to right child.
 */
class TreeNode {
    int val; // node's value
    TreeNode left; // pointer to left child
    TreeNode right; // pointer to right child

    // Default constructor.
    TreeNode() {
    }

    // Constructor with node value.
    TreeNode(int val) {
        this.val = val;
    }

    // Constructor with node value, left child, and right child.
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * This class contains method to validate if a binary tree is a binary search
 * tree (BST).
 */
class Solution {
    private Integer previousValue; // variable to store the previously visited node's value

    /**
     * Validates if the given binary tree is a valid binary search tree (BST).
     *
     * @param root The root of the binary tree to check.
     * @return true if the given tree is a BST, false otherwise.
     */
    public boolean isValidBST(TreeNode root) {
        previousValue = null; // Initialize previousValue as null before starting traversal
        return inOrderTraversal(root);
    }

    /**
     * Performs an in-order depth-first traversal on the binary tree to validate BST
     * property.
     * It ensures that every node's value is greater than the values of all nodes in
     * its left subtree
     * and less than the values of all nodes in its right subtree.
     *
     * @param node The current node being visited in the traversal.
     * @return true if the subtree rooted at 'node' satisfies BST properties, false
     *         otherwise.
     */
    private boolean inOrderTraversal(TreeNode node) {
        if (node == null) {
            return true; // Base case: An empty tree is a valid BST.
        }
        // Traverse the left subtree. If it's not a valid BST, return false immediately.
        if (!inOrderTraversal(node.left)) {
            return false;
        }
        // Check the current node value with the previous node's value.
        // As it's an in-order traversal, previousValue should be less than the current
        // node's value.
        if (previousValue != null && previousValue >= node.val) {
            return false; // The BST property is violated.
        }
        previousValue = node.val; // Update previousValue with the current node's value.
        // Traverse the right subtree. If it's not a valid BST, return false
        // immediately.
        if (!inOrderTraversal(node.right)) {
            return false;
        }
        return true; // All checks passed, it's a valid BST.
    }
}