/*
 * Binary Tree Maximum Path Sum - 124
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

 class Solution {
    private int maxSum = Integer.MIN_VALUE; // Initialize maxSum with the smallest possible integer value.

    // Returns the maximum path sum of any path that goes through the nodes of the
    // given binary tree.
    public int maxPathSum(TreeNode root) {
        calculateMaxPathFromNode(root);
        return maxSum;
    }

    // A helper method that computes the maximum path sum from a given node and
    // updates the overall maxSum.
    private int calculateMaxPathFromNode(TreeNode node) {
        if (node == null) {
            // If the current node is null, we return 0 since null contributes nothing to
            // the path sum.
            return 0;
        }
        // Compute and get the maximum sum of paths from the left child;
        // if the value is negative, we ignore the left child's contribution by taking
        // 0.
        int leftMaxSum = Math.max(0, calculateMaxPathFromNode(node.left));
        // Compute and get the maximum sum of paths from the right child;
        // if the value is negative, we ignore the right child's contribution by taking
        // 0.
        int rightMaxSum = Math.max(0, calculateMaxPathFromNode(node.right));
        // Update maxSum with the greater of the current maxSum or the sum of the
        // current node value plus leftMaxSum and rightMaxSum.
        // This accounts for the scenario where the path involving the current node and
        // its left and right children yields the max path sum.
        maxSum = Math.max(maxSum, node.val + leftMaxSum + rightMaxSum);
        // This call must return the maximum path sum including the currently evaluated
        // node and one of its subtrees
        // since a path cannot have branches and must be straight through the parents or
        // children nodes.
        return node.val + Math.max(leftMaxSum, rightMaxSum);
    }
}


