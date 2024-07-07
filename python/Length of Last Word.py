# 58 -Length of Last Word

"""
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

"""


def lengthOfLastWord(s: str) -> int:
    length = 0
    i = len(s) - 1
    while i >= 0 and s[i] == ' ':
        i -= 1
    while i >= 0 and s[i] != ' ':
        length += 1
        i -= 1
    return length

