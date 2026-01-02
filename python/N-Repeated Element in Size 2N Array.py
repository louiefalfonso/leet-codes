# N-Repeated Element in Size 2N Array - 961

class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        s = set()
        for x in nums:
            if x in s:
                return x
            s.add(x)