# Check If a String Contains All Binary Codes of Size K - 1461

class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        n = len(s)
        m = 1 << k
        if n - k + 1 < m:
            return False
        ss = {s[i : i + k] for i in range(n - k + 1)}
        return len(ss) == m