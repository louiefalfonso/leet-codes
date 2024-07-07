# 1768. Merge Strings Alternately

# Example 1:
#
# Input: word1 = "abc", word2 = "pqr"
# Output: "apbqcr"
# Explanation: The merged string will be merged as so:
# word1:  abc
# word2:  pqr
# merged: a p b q c

class Solution(object):
    def mergeAlternately(self, word1, word2):
        merged = ""
        flag = True
        for i, c in enumerate(word1):
            ci = i
            merged = merged + c
            if flag and len(word2) > i:
                merged = merged + word2[i]
                if len(word2) == (i + 1):
                    flag = False
        if flag:
            merged = merged + word2[ci + 1:]
        return merged
