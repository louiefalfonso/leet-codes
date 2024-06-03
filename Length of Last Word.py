# 58 -Length of Last Word

"""
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

"""


def lengthOfLastWord(s: str) -> int:
    """
    :type s: str
    :rtype: int
    """
    i = len(s) - 1
    length = 0

    while i >= 0 and s[i] == " ":
        i -= 1

    while i >= 0 and s[i] != " ":
        length += 1
        i -= 1

    return length


class Solution(object):
    pass

