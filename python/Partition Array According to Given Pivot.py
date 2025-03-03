# Partition Array According to Given Pivot - 2161

class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:

        # Initialize three lists to store elements less than, equal to, and greater than the pivot
        a, b, c = [], [], []
        
        # Iterate through each element in the input array
        for x in nums:
            # If the current element is less than the pivot, add it to the 'less than' list
            if x < pivot:
                a.append(x)
            # If the current element is equal to the pivot, add it to the 'equal to' list
            elif x == pivot:
                b.append(x)
            # If the current element is greater than the pivot, add it to the 'greater than' list
            else:
                c.append(x)
        # Combine the three lists in the correct order and return the result
        return a + b + c