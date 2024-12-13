/*
 * Longest ZigZag Path in a Binary Tree - 1372
 */

 /**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Solution class contains methods to calculate the longest zigzag path in a
 * binary tree.
 */
class Solution {
    // Variable to store the length of the longest zigzag path found so far.
    private int longestZigZagLength;

    /**
     * Method to find the length of the longest zigzag path starting from the root
     * node.
     *
     * @param root The root node of the binary tree.
     * @return The length of the longest zigzag path in the tree.
     */
    public int longestZigZag(TreeNode root) {
        // Initialize with the assumption that there's no zigzag path.
        longestZigZagLength = 0;

        // Start Depth First Search traversal from the root.
        dfs(root, 0, 0);

        // Return the length of the longest zigzag path found.
        return longestZigZagLength;
    }

    /**
     * A recursive DFS method that traverses the tree to find the longest zigzag
     * path.
     *
     * @param node        The current node being visited.
     * @param leftLength  The current length of the zigzag path when coming from a
     *                    left child.
     * @param rightLength The current length of the zigzag path when coming from a
     *                    right child.
     */
    private void dfs(TreeNode node, int leftLength, int rightLength) {
        // If the node is null, we have reached beyond leaf, so return.
        if (node == null) {
            return;
        }

        // Update the longestZigZagLength with the maximum path length seen so far at
        // this node.
        longestZigZagLength = Math.max(longestZigZagLength, Math.max(leftLength, rightLength));

        // Traverse left - the zigzag is coming from the right so add 1 to rightLength.
        dfs(node.left, rightLength + 1, 0);

        // Traverse right - the zigzag is coming from the left so add 1 to leftLength.
        dfs(node.right, 0, leftLength + 1);
    }
}