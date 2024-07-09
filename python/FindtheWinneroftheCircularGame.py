# 1823. Find the Winner of the Circular Game

class Solution(object):
    def findTheWinner(self, n, k):
        a = list(range(1, n + 1))
        start = 0
        while len(a) > 1:
            start = (start + (k - 1)) % len(a)
            a.pop(start)
        return a[0]
