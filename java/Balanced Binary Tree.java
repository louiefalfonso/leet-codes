// Balanced Binary Tree - 110

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
    
    //Checks if a binary tree is balanced.
    public boolean isBalanced(TreeNode root) {
        // If the height of the tree is non-negative, it is balanced
        return height(root) >= 0;
    }

    
    //Calculates the height of a binary tree.
    private int height(TreeNode root) {
        // Base case: an empty tree has height 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the heights of the left and right subtrees
        int l = height(root.left);
        int r = height(root.right);

        // If either subtree is unbalanced, or if the difference in heights is too
        // large, return -1
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }

        // Otherwise, return the height of the tree (1 plus the maximum height of the
        // subtrees)
        return 1 + Math.max(l, r);
    }
}