/*
 * Binary Tree Level Order Traversal - 102
 */

 import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

// Definition for a binary tree node.
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
    // Method to perform a level order traversal of a binary tree.
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Create a list to hold the result.
        List<List<Integer>> result = new ArrayList<>();

        // Return an empty list if the tree is empty.
        if (root == null) {
            return result;
        }

        // Create a queue to hold nodes at each level.
        Deque<TreeNode> queue = new ArrayDeque<>();

        // Start the level order traversal from the root.
        queue.offer(root);

        // While there are nodes to process
        while (!queue.isEmpty()) {
            // Temporary list to store the values of nodes at the current level.
            List<Integer> level = new ArrayList<>();

            // Process all nodes at the current level.
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; ++i) {
                // Retrieve and remove the head of the queue.
                TreeNode currentNode = queue.poll();

                // Add the node's value to the temporary list.
                level.add(currentNode.val);

                // If the left child exists, add it to the queue for the next level.
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                // If the right child exists, add it to the queue for the next level.
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Add the temporary list to the result list.
            result.add(level);
        }

        // Return the list of levels.
        return result;
    }
}