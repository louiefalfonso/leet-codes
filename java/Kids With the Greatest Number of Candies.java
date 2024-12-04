/*
 Kids With the Greatest Number of Candies - 1431

 There are n kids with candies. You are given an integer array candies, where each candies[i] 
 represents the number of candies the ith kid has, and an integer extraCandies, denoting the number 
 of extra candies that you have.

Return a boolean array result of length n, where result[i] is true if, 
after giving the ith kid all the extraCandies, they will have the greatest number of candies 
among all the kids, or false otherwise.

Note that multiple kids can have the greatest number of candies.
 */

import java.util.List;
import java.util.ArrayList;

 class Solution {

    // Function to determine which kids can have the greatest number of candies
    // after they receive an additional amount of extraCandies.
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        // Find the maximum number of candies that any kid currently has.
        int maxCandies = Integer.MIN_VALUE;
        
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        // List to store the results, whether each kid can have the maximum number
        // of candies after receiving extraCandies.
        List<Boolean> result = new ArrayList<>();

        // Loop through each kid's candies to determine if they can reach maxCandies
        // with their current candies plus extraCandies.
        for (int candy : candies) {
            // If the current kid's candies plus extraCandies is greater than or
            // equal to maxCandies, add 'true' to the result list, otherwise add 'false'.
            result.add(candy + extraCandies >= maxCandies);
        }

        // Return the result list.
        return result;
    }
}
