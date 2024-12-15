/*
 * Search in a Binary Search Tree - 700
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
    /**
     * Searches for a node with a given value in a Binary Search Tree.
     * 
     * @param root The root of the binary search tree.
     * @param val  The value to search for.
     * @return The subtree rooted with the target value; or null if value doesn't
     *         exist in the tree.
     */
    public TreeNode searchBST(TreeNode root, int val) {
        // Base case: if the root is null or root value equals the search value, return
        // the root.
        if (root == null || root.val == val) {
            return root;
        }

        // If the value of the root is less than the search value, search in the right
        // subtree.
        // Otherwise, search in the left subtree.
        return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}