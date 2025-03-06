# Path Sum -112

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        
        # Define a helper function for depth-first search (DFS)
        def dfs(root, s):
            # Base case: if the current node is None, return False
            if root is None:
                return False
            
            # Add the value of the current node to the current sum
            s += root.val
            
            # If the current node is a leaf node (i.e., it has no children) and the current sum equals the target sum, return True
            if root.left is None and root.right is None and s == targetSum:
                return True
            
            # Recursively search for a path in the left and right subtrees
            # If either subtree has a path that sums up to the target sum, return True
            return dfs(root.left, s) or dfs(root.right, s)

        # Start the DFS from the root node with an initial sum of 0
        return dfs(root, 0)