# Maximum Score From Grid Operations - 3225

class Solution:
    def maximumScore(self, grid: list[list[int]]) -> int:
        n = len(grid)
        # prefix[j][i] := sum of first i elements in j-th column
        prefix = [[0] * (n + 1) for _ in range(n)]
        for j in range(n):
            for i in range(n):
                prefix[j][i + 1] = prefix[j][i] + grid[i][j]
        
        # dp[i] := max score using current column with i black cells
        dp = [0] * (n + 1)
        
        for j in range(n):
            new_dp = [0] * (n + 1)
            # col_sums[i] is max score ending with i black cells in this column
            col_sums = [0] * (n + 1)
            for curr in range(n + 1):
                for prev in range(n + 1):
                    # If current column is taller, add score
                    if curr > prev:
                        score = prefix[j][curr] - prefix[j][prev]
                        col_sums[curr] = max(col_sums[curr], dp[prev] + score)
                    # If current is shorter, score added differently
                    else:
                        col_sums[curr] = max(col_sums[curr], dp[prev])
            
            # Update DP table for next column
            new_dp = col_sums
            dp = new_dp
            
        return max(dp)
