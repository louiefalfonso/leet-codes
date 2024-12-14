/*
 * Binary Tree Right Side View - 199
 */

 import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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

    // Constructor to initialize binary tree nodes with values and its children
    // reference
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    // Function to get a list of integers representing the right side view of the
    // binary tree
    public List<Integer> rightSideView(TreeNode root) {
        // Initialize an answer list to store the right side view
        List<Integer> answer = new ArrayList<>();

        // Return empty list if the root is null
        if (root == null) {
            return answer;
        }

        // Initialize a dequeue to perform level order traversal
        Deque<TreeNode> queue = new ArrayDeque<>();

        // Add the root to the queue as the start of traversal
        queue.offer(root);

        // Perform a level order traversal to capture the rightmost element at each
        // level
        while (!queue.isEmpty()) {
            // Get the rightmost element of the current level and add to the answer list
            answer.add(queue.peekLast().val);

            // Iterate through nodes at current level
            for (int n = queue.size(); n > 0; --n) {
                // Poll the node from the front of the queue
                TreeNode node = queue.poll();

                // If left child exists, add it to the queue
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // If right child exists, add it to the queue
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        // Return the list containing the right side view of the tree
        return answer;
    }
}
