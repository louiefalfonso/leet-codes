# Find Minimum Operations to Make All Elements Divisible by Three - 3190

class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        return sum(x % 3 != 0 for x in nums)