# Product of Array Except Self - 238

class Solution:
    def productExceptSelf(self, nums)

        # Get the length of the input list
        n = len(nums)
        
        # Initialize the output list with 1's, which will store the product of all numbers except the current number
        output = [1] * n
    
        # Initialize the left product variable to 1, which will store the product of all numbers to the left of the current number
        left_product = 1
        # Iterate through the list from left to right
        for i in range(n):
            # Multiply the current output value with the left product
            output[i] *= left_product
            # Update the left product by multiplying it with the current number
            left_product *= nums[i]
        
        # Initialize the right product variable to 1, which will store the product of all numbers to the right of the current number
        right_product = 1
        # Iterate through the list from right to left
        for i in range(n - 1, -1, -1):
            # Multiply the current output value with the right product
            output[i] *= right_product
            # Update the right product by multiplying it with the current number
            right_product *= nums[i]
    
        # Return the output list, which contains the product of all numbers except the current number for each position
        return output