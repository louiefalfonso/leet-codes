// Subsets - 78

import java.util.ArrayList;
import java.util.List;

class Solution {

    // method takes an array of integers as input and returns a list of all possible subsets of the array.
    public List<List<Integer>> subsets(int[] nums) {
        // Get the length of the input array
        int n = nums.length;
        // Create an empty list to store the subsets
        List<List<Integer>> ans = new ArrayList<>();
        // Iterate over all possible bit masks that can be formed using the input array
        for (int mask = 0; mask < 1 << n; ++mask) {
            // Create an empty list to store the current subset
            List<Integer> t = new ArrayList<>();
            // Iterate over all elements in the input array
            for (int i = 0; i < n; ++i) {
                // If the i-th bit in the current bit mask is set, add the corresponding element
                // to the current subset
                if (((mask >> i) & 1) == 1) {
                    t.add(nums[i]);
                }
            }
            // Add the current subset to the list of all subsets
            ans.add(t);
        }
        // Return the list of all subsets
        return ans;
    }
}