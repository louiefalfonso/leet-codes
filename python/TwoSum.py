# 1. Two Sum

"""
Example:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

"""


class Solution(object):
    def merge(self, nums1, m, nums2, n):
        # If nums2 is empty, there's nothing to merge, so return
        if n == 0: 
            return
        
        # Get the length of nums1 and the last index
        len1 = len(nums1)
        end_idx = len1 - 1
        
        # Merge elements from nums1 and nums2 into nums1
        while n > 0 and m > 0:
            # Compare the last elements of nums1 and nums2
            if nums2[n - 1] >= nums1[m - 1]:
                # If the last element of nums2 is larger, place it at the current end_idx
                nums1[end_idx] = nums2[n - 1]
                n -= 1
            else:
                # If the last element of nums1 is larger, place it at the current end_idx
                nums1[end_idx] = nums1[m - 1]
                m -= 1
            # Move the end_idx to the left
            end_idx -= 1
        
        # If there are remaining elements in nums2, copy them into nums1
        while n > 0:
            nums1[end_idx] = nums2[n - 1]
            n -= 1
            end_idx -= 1