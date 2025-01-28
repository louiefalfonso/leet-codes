# Contains Duplicate - 217


class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        
        # Using set to store the unique elements
        num_set = set()
        
        # Iterate through the array
        for n in nums:
            # If the element is already in the set, return True
            if n in num_set:
                return True
            # Otherwise, add the element to the set
            num_set.add(n)
            
        # If the loop completes, return
        return False
         