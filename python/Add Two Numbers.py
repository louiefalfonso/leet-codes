# Add Two Numbers - 2

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:

        # Create a dummy node to simplify the code and avoid edge cases
        dummy = ListNode()
        
        # Initialize the carry and current node pointers
        carry, current = 0, dummy
        
        # Continue iterating until we've processed all nodes in both lists and there's no carry left
        while l1 or l2 or carry:
            # Calculate the sum of the current nodes' values and the carry
            s = (l1.val if l1 else 0) + (l2.val if l2 else 0) + carry
            
            # Split the sum into the carry and the value for the current node
            carry, val = divmod(s, 10)
            
            # Create a new node with the calculated value and link it to the current node
            current.next = ListNode(val)
            
            # Move the current node pointer to the newly created node
            current = current.next
            
            # Move the pointers for the input lists to the next nodes
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        
        # Return the next node of the dummy node, which is the actual head of the result list
        return dummy.next