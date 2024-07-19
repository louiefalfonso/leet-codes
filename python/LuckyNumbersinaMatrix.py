# 1380. Lucky Numbers in a Matrix

class Solution(object):
    def luckyNumbers (self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        m, n = len(matrix), len(matrix[0])
        row_mins = [min(row) for row in matrix]
        col_maxes = [max([matrix[i][j] for i in range(m)]) for j in range(n)]
        return [num for num in row_mins if num in col_maxes]