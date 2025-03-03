# Construct Binary Tree from Inorder and Postorder Traversal - 106

from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, value=0, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:

        
        # Base case: if postorder list is empty, return None
        if not postorder:
            return None
            
        # The last element of postorder list is the root value
        root_value = postorder[-1]
        
        # Create a new TreeNode with the root value
        root = TreeNode(val=root_value)
        
        # Find the index of the root value in the inorder list
        index = inorder.index(root_value)

        # Recursively build the left subtree using the inorder and postorder lists up to the index
        root.left = self.buildTree(inorder[:index], postorder[:index])
        
        # Recursively build the right subtree using the inorder and postorder lists from index + 1 to the end
        root.right = self.buildTree(inorder[index + 1 :], postorder[index:-1])
        
        # Return the constructed TreeNode
        return root