# 70. Climbing Stairs

#You are climbing a staircase. It takes n steps to reach the top.

#Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



#Example 1:

#Input: n = 2
#Output: 2
#Explanation: There are two ways to climb to the top.
#1. 1 step + 1 step
#2. 2 steps


class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        memo = {}
        def climb(n):
            if n in memo:
                return memo[n]

            if (n == 1):
                return 1
            if (n == 2):
                return 2
            else:
                result = climb(n - 1) + climb(n - 2)
            memo[n] = result
            print(memo)
            return result

        return climb(n)
