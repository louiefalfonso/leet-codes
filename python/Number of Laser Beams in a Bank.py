# Number of Laser Beams in a Bank - 2125

class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        ans = pre = 0
        for row in bank:
            if (cur := row.count("1")) > 0:
                ans += pre * cur
                pre = cur
        return ans