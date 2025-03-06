# Find Missing and Repeated Values - 2965

class Solution:
    def findMissingAndRepeatedValues(self, grid):

        # Get the size of the grid (number of rows)
        n = len(grid)
        
        # Create a count array to store the frequency of each number
        # The size of the count array is (n * n + 1) to accommodate numbers from 1 to n * n
        cnt = [0] * (n * n + 1)
        
        # Iterate through each row and each value in the grid
        for row in grid:
            for v in row:
                # Increment the count of the current value
                cnt[v] += 1
        
        # Initialize the answer array to store the repeated and missing values
        ans = [0] * 2
        
        # Iterate through the count array to find the repeated and missing values
        for i in range(1, n * n + 1):
            # If the count of the current number is 2, it's the repeated value
            if cnt[i] == 2:
                ans[0] = i
            # If the count of the current number is 0, it's the missing value
            if cnt[i] == 0:
                ans[1] = i
        
        # Return the answer array containing the repeated and missing values
        return ans