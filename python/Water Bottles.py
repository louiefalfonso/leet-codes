# 1518. Water Bottles

class Solution(object):
    def numWaterBottles(self, numBottles, numExchange):
        totalBottles = numBottles

        while numBottles >= numExchange:
            newBottles = numBottles // numExchange
            remainingBottles = numBottles % numExchange
            totalBottles += newBottles
            numBottles = newBottles + remainingBottles

        return totalBottles
