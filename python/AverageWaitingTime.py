# 1701. Average Waiting Time

class Solution(object):
    def averageWaitingTime(self, customers):
        """
        :type customers: List[List[int]]
        :rtype: float
        """
        ans = 0.0
        wait = 0.0
        for c in customers:
            if wait < c[0]:
                ans += c[1]
                wait = c[0] + c[1]
            else:
                wait += c[1]
                ans += (wait - c[0])
        return ans / len(customers)
