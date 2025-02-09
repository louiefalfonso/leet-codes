// Count Number of Bad Pairs - 2364

import java.util.*;

class Solution {

    //  method takes an array of integers as input and returns the number of "bad pairs" in the array.
    public long countBadPairs(int[] nums) {
        
        // Create a hashmap to store the count of differences between the index and the
        // value at that index.
        Map<Integer, Integer> cnt = new HashMap<>();
        // Initialize the answer variable to 0.
        long ans = 0;
        // Iterate over all elements in the input array.
        for (int i = 0; i < nums.length; ++i) {
            // Calculate the difference between the current index and the value at that
            // index.
            int x = i - nums[i];
            // The number of "bad pairs" ending at the current index is equal to the number
            // of indices minus the number of indices with the same difference.
            // We use the getOrDefault method to handle the case where the difference is not
            // in the hashmap yet.
            ans += i - cnt.getOrDefault(x, 0);
            // Update the count of the current difference in the hashmap.
            cnt.merge(x, 1, Integer::sum);
        }
        // Return the total number of "bad pairs".
        return ans;
    }
}