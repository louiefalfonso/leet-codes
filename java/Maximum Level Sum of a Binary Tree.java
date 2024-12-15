/*
 * Maximum Level Sum of a Binary Tree - 1161
 */

import java.util.Deque;
import java.util.ArrayDeque;

 // Definition for a binary tree node.
class TreeNode {
    int val; // Node's value
    TreeNode left; // Reference to the left child node
    TreeNode right; // Reference to the right child node

    // Constructors for TreeNode
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
    // Function to find the level of the binary tree with the maximum sum
    public int maxLevelSum(TreeNode root) {
        // Queue to store nodes of tree level-wise
        Deque<TreeNode> queue = new ArrayDeque<>();
        // Adding the root to the queue as the starting point
        queue.offer(root);

        // Variables to keep track of the maximum level sum and corresponding level
        int maxSum = Integer.MIN_VALUE; // Initialized to minimum value
        int level = 0; // Level counter
        int maxLevel = 0; // Level with max sum

        // Loop through each level of the tree
        while (!queue.isEmpty()) {
            level++; // Increment the level counter
            int levelSum = 0; // Reset the level sum for the current level

            // Calculate the sum of all nodes at the current level
            for (int count = queue.size(); count > 0; count--) {
                TreeNode node = queue.pollFirst(); // Get the next node from the queue
                levelSum += node.val; // Add the node's value to the level sum

                // Add child nodes to the queue for the next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Update max sum and corresponding level if the current level has a greater sum
            if (maxSum < levelSum) {
                maxSum = levelSum;
                maxLevel = level;
            }
        }

        // Return the level with the maximum sum
        return maxLevel;
    }
}

