# Merge Two 2D Arrays by Summing Values - 2570

class Solution:
    def mergeArrays(
        self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        
        # Create a Counter object to store the sum of values for each index
        cnt = Counter()
        
        # Iterate over the combined list of nums1 and nums2
        for i, v in nums1 + nums2:
            # For each index, add the value to the Counter
            cnt[i] += v
        
        # Return the sorted items from the Counter as a list of lists
        return sorted(cnt.items())