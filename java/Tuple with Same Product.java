// Tuple with Same Product - 1726

import java.util.HashMap;
import java.util.Map;

class Solution {
    
    //Returns the number of tuples that have the same product.
    public int tupleSameProduct(int[] nums) {
        // Map to store the count of each product
        Map<Integer, Integer> cnt = new HashMap<>();

        // Generate all possible pairs of numbers and count their products
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                // Calculate the product of the current pair
                int x = nums[i] * nums[j];

                // Increment the count of the product
                cnt.merge(x, 1, Integer::sum);
            }
        }

        // Initialize the answer
        int ans = 0;

        // For each product, calculate the number of tuples that can be formed
        // Since each tuple has 4 numbers, we multiply the count by 8 (4 choose 2)
        for (int v : cnt.values()) {
            // Calculate the number of tuples that can be formed with the current product
            // This is done by calculating the number of ways to choose 2 numbers out of v
            ans += v * (v - 1) / 2;
        }

        // Multiply the answer by 8 to account for the 4 numbers in each tuple
        return ans << 3; // equivalent to ans * 8
    }
}