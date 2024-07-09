# 1431. Kids With the Greatest Number of Candies

# Example 1:

# Input: candies = [2,3,5,1,3], extraCandies = 3
# Output: [true,true,true,false,true]
# Explanation: If you give all extraCandies to:
# - Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
# - Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
# - Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
# - Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
# - Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.


class Solution(object):
    def kidsWithCandies(self, candies, extraCandies):
        highest = max(candies)
        values = []
        for i in range(0, len(candies)):
            reference = candies[i] + extraCandies
            if reference >= highest:
                values += [True]
            else:
                values += [False]
        return values
