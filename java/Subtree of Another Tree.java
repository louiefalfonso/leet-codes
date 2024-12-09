/*
 * Subtree of Another Tree - 572
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
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // If the main tree is null, subRoot cannot be a subtree
        if (root == null) {
            return false;
        }
        // Check if the tree rooted at this node is identical to the subRoot
        // or if the subRoot is a subtree of the left or right child
        return isIdentical(root, subRoot) || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    /**
     * Helper method to determine if two binary trees are identical.
     *
     * @param root1 The root node of the first tree.
     * @param root2 The root node of the second tree.
     * @return boolean indicating whether the trees are identical or not.
     */
    private boolean isIdentical(TreeNode root1, TreeNode root2) {
        // If both trees are empty, then they are identical
        if (root1 == null && root2 == null) {
            return true;
        }
        // If both are not null, compare their values and check their left & right
        // subtrees
        if (root1 != null && root2 != null) {
            return root1.val == root2.val && isIdentical(root1.left, root2.left)
                    && isIdentical(root1.right, root2.right);
        }
        // If one is null and the other isn't, they are not identical
        return false;
    }
}