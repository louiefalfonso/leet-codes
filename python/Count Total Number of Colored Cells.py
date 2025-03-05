# Count Total Number of Colored Cells - 2579

class Solution:
    def coloredCells(self, n: int) -> int:
        return 2 * n * (n - 1) + 1