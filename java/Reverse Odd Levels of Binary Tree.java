/*
 * Reverse Odd Levels of Binary Tree - 2415
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

 import java.util.ArrayDeque;
 import java.util.ArrayList;
 import java.util.Deque;
 import java.util.List;
 import java.util.Queue;
 
 class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        // Queue for performing level order traversal
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        // Level marker, starting from 0 (root level)
        int level = 0;

        // Loop through levels of the tree
        while (!queue.isEmpty()) {
            // Temporary list to hold nodes of the current level
            List<TreeNode> currentLevelNodes = new ArrayList<>();

            // Iterate over all nodes at the current level
            for (int count = queue.size(); count > 0; count--) {
                // Retrieve and remove the head of the queue
                TreeNode node = queue.pollFirst();

                // If we're on an odd level, add the node to our list
                if (level % 2 == 1) {
                    currentLevelNodes.add(node);
                }

                // If left child exists, add it to the queue for next level
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // If right child exists, add it to the queue for next level
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // If the current level is odd, we reverse the values of the nodes at this level
            if (!currentLevelNodes.isEmpty()) {
                int startIndex = 0;
                int endIndex = currentLevelNodes.size() - 1;

                // Swap the values of nodes from start to end until they reach the middle
                while (startIndex < endIndex) {
                    // Swapping values of the node
                    int tempVal = currentLevelNodes.get(startIndex).val;
                    currentLevelNodes.get(startIndex).val = currentLevelNodes.get(endIndex).val;
                    currentLevelNodes.get(endIndex).val = tempVal;

                    // Move towards the center
                    startIndex++;
                    endIndex--;
                }
            }

            // Move to next level
            level++;
        }

        // Return the modified tree
        return root;
    }
}