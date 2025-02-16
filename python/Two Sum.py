# Two Sum - 1

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        # Create a dictionary to store the numbers and their indices
        seen = {}
        
        # Iterate over the list of numbers with their indices
        for i, num in enumerate(nums):

            # Calculate the complement of the current number with respect to the target
            complement = target - num
            
            # If the complement  was seen before, return its index and the current index
            if complement in seen:
                return [seen[complement], i]
            
            # Otherwise, add the current number and its index to the dictionary
            seen[num] = i
        
        # Iterated over the entire list and haven't found a solution, return an empty list
        return []