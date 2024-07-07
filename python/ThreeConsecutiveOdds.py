# Given an integer array arr, return true if there are three consecutive odd numbers in the array.
# Otherwise, return false.

# Example 1:

# Input: arr = [2,6,4,1]
# Output: false
# Explanation: There are no three consecutive odds.

class Solution(object):
    def threeConsecutiveOdds(self, arr):
        for i in range(len(arr) - 2):
            if (arr[i ]% 2 != 0) and  (arr[ i +1 ]% 2 != 0) and  (arr[ i +2 ]% 2 != 0) :
                return True
        return False
