# 2108. Find First Palindromic String in the Array

# Given an array of strings words, return the first palindromic string in the array.
# If there is no such string, return an empty string "".
# A string is palindromic if it reads the same forward and backward.

# Example 1:

# Input: words = ["abc","car","ada","racecar","cool"]
# Output: "ada"
# Explanation: The first string that is palindromic is "ada".
# Note that "racecar" is also palindromic, but it is not the first.

class Solution(object):
    def firstPalindrome(self, words):
        for i in words:
            if i == i[::-1]:
                return i
        return ""
