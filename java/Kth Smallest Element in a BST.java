/*
 * Kth Smallest Element in a BST - 230
 */

 import java.util.ArrayDeque;
 import java.util.Deque;
 
 class Solution {
    // Method to find the k-th smallest element in a BST
    public int kthSmallest(TreeNode root, int k) {
        // Stack to simulate the in-order traversal iteratively
        Deque<TreeNode> stack = new ArrayDeque<>();

        // Continue until we have no unfinished nodes to process
        while (root != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current subtree
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // Process leftmost node
            root = stack.pop();
            // Decrement k and if it becomes 0, it means we found our k-th smallest
            if (--k == 0) {
                return root.val;
            }
            // Move to right subtree to continue the process
            root = root.right;
        }
        // If k is not valid, return 0 as a default value
        return 0;
    }
}