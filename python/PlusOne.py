# 66. Plus One

# You are given a large integer represented as an integer array digits, where each digits[i]
# is the ith digit of the integer.
# The digits are ordered from most significant to least significant in left-to-right order.
# The large integer does not contain any leading 0's.

# Example 1:
#
# Input: digits = [1,2,3]
# Output: [1,2,4]
# Explanation: The array represents the integer 123.
# Incrementing by one gives 123 + 1 = 124.
# Thus, the result should be [1,2,4].

class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """

        strings = ""
        for number in digits:
            strings += str(number)

        temp = str(int(strings) + 1)

        return [int(temp[i]) for i in range(len(temp))]


