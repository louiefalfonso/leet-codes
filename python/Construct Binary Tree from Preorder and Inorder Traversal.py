# Construct Binary Tree from Preorder and Inorder Traversal - 105

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def buildTree(self, preorder, inorder):
        
        # Base case: if either preorder or inorder is empty, return None
        if not preorder or not inorder:
            return None
        
        # Create the root node with the first element of preorder
        root = TreeNode(preorder[0])
        
        # Find the index of the root node in the inorder traversal
        mid = inorder.index(preorder[0])
        
        # Recursively build the left subtree with the corresponding elements from preorder and inorder
        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
        
        # Recursively build the right subtree with the corresponding elements from preorder and inorder
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])
        
        # Return the constructed binary tree
        return root
    
