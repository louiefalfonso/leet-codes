# Mirror Distance of an Integer - 3783

class Solution:
    def mirrorDistance(self, n: int) -> int:
        return abs(n - int(str(n)[::-1]))