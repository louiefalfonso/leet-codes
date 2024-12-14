/*
 * Construct Binary Tree from Preorder and Inorder Traversal - 105
 */

 import java.util.HashMap;
 import java.util.Map;
 class Solution {
    private int[] preorderTraversal; // Array to hold the preorder traversal of the tree
    private Map<Integer, Integer> inorderIndices = new HashMap<>(); // Map to hold the indices of values in inorder
                                                                    // traversal

    // Builds the binary tree given preorder and inorder traversal arrays
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length; // The number of nodes in the tree
        this.preorderTraversal = preorder; // Assigning preorder traversal array to the class variable for global access
                                           // in this context

        // Mapping each value from inorder array to its index for quick lookup
        for (int i = 0; i < n; ++i) {
            inorderIndices.put(inorder[i], i);
        }
        // Initiates the recursive tree building process from the whole range of given
        // arrays
        return buildTreeRecursive(0, 0, n);
    }

    // Recursive method to build the binary tree
    private TreeNode buildTreeRecursive(int preorderStart, int inorderStart, int size) {
        if (size <= 0) { // Base case: if there are no elements to consider, return null
            return null;
        }

        // Fetching the current value from the preorder array (root of the subtree)
        int rootValue = preorderTraversal[preorderStart];
        // Getting the index of the current root in the inorder array
        int inorderRootIndex = inorderIndices.get(rootValue);
        // Calculating the number of nodes in the left subtree
        int leftSubtreeSize = inorderRootIndex - inorderStart;

        // Building the left subtree recursively
        TreeNode leftSubtree = buildTreeRecursive(preorderStart + 1, inorderStart, leftSubtreeSize);

        // Building the right subtree recursively
        // Need to move past the left subtree in the preorder array, hence
        // "preorderStart + 1 + leftSubtreeSize"
        TreeNode rightSubtree = buildTreeRecursive(preorderStart + 1 + leftSubtreeSize, inorderRootIndex + 1,
                size - 1 - leftSubtreeSize);

        // Creating the current root node with computed left and right subtrees
        return new TreeNode(rootValue, leftSubtree, rightSubtree);
    }
}

/**
 * Definition for a binary tree node.
 * A basic TreeNode class defining the structure of each node in the binary
 * tree.
 */
class TreeNode {
    int val; // The value of the node
    TreeNode left; // Pointer to the left child
    TreeNode right; // Pointer to the right child

    // Constructor for creating a leaf node with a specific value
    TreeNode(int val) {
        this.val = val;
    }

    // Constructor for creating a node linked to its children
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
