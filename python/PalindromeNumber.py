# 9. Palindrome Number

class Solution(object):
    def isPalindrome(self, x):
        if x < 0:
            return False
        reversed_num = 0
        original_num = x
        while x != 0:
            remainder = x % 10
            reversed_num = reversed_num * 10 + remainder
            x = x // 10
        return original_num == reversed_num