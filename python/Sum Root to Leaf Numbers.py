# Sum Root to Leaf Numbers - 129

class TreeNode:
    # TreeNode class definition is provided for context.
    def __init__(self, val=0, left=None, right=None):
        self.val = val  # The value of the node.
        self.left = left  # Pointer to the left child.
        self.right = right  # Pointer to the right child.

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        # Helper function to perform depth-first search.
        def dfs(node, num_sum):
            # If the current node is None, we've reached a leaf or the tree is empty.
            if not node:
                return 0
          
            # Update the sum for the current path: 
            # previous sum times 10 plus the current node's value.
            num_sum = num_sum * 10 + node.val
          
            # If we're at a leaf node, return the current sum.
            if not node.left and not node.right:
                return num_sum
          
            # Continue the depth-first search on left and right subtrees, adding their sums.
            return dfs(node.left, num_sum) + dfs(node.right, num_sum)
      
        # Start the depth-first search with the root node and an initial sum of 0.
        return dfs(root, 0)