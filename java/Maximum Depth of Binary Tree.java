/*
 * Maximum Depth of Binary Tree - 104
 */

 // Definition for a binary tree node.
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    // Constructor to create a leaf node.
    TreeNode(int value) {
        this.value = value;
    }

    // Constructor to create a node with specific children.
    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // Calculates the maximum depth of a binary tree.
    public int maxDepth(TreeNode root) {
        // If the root is null, the depth is 0.
        if (root == null) {
            return 0;
        }

        // Recursively compute the depth of the left subtree.
        int leftDepth = maxDepth(root.left);

        // Recursively compute the depth of the right subtree.
        int rightDepth = maxDepth(root.right);

        // The depth of the current node is the greater of its two children's depths
        // plus one.
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
