/*
 * Serialize and Deserialize Binary Tree - 297
 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        final String[] vals = data.split(" ");
        Queue<String> q = new ArrayDeque<>(List.of(vals));
        return preorder(q);
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("n ");
            return;
        }

        sb.append(root.val).append(" ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    private TreeNode preorder(Queue<String> q) {
        final String s = q.poll();
        if (s.equals("n"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = preorder(q);
        root.right = preorder(q);
        return root;
    }
}
