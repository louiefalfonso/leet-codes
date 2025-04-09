 // Validate Binary Search Tree - 98
 
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private Integer previousValue;
    
    public boolean isValidBST(TreeNode root) {
        previousValue = null; 
        return inOrderTraversal(root);
    }

    private boolean inOrderTraversal(TreeNode node) {
        if (node == null) {
            return true; 
        }
        
        if (!inOrderTraversal(node.left)) {
            return false;
        }
        
        if (previousValue != null && previousValue >= node.val) {
            return false; 
        }
        previousValue = node.val; 

        if (!inOrderTraversal(node.right)) {
            return false;
        }
        return true; 
    }
}