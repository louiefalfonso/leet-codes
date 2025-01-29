// Permutations - 46

import java.util.ArrayList;
import java.util.List;

class Solution {
    
    // Store the final result: all permutations of the input array
    private List<List<Integer>> ans = new ArrayList<>();

    // Temporary list to store the current permutation being built
    private List<Integer> t = new ArrayList<>();

    // Keep track of which elements have been used in the current permutation
    private boolean[] vis;

    // Store the input array
    private int[] nums;

     // Generate all permutations of the input array.
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        // Initialize the visibility array
        vis = new boolean[nums.length];
        // Start the depth-first search
        dfs(0);
        return ans;
    }

    
     // Recursive depth-first search function to generate all permutations.
    private void dfs(int i) {
        // Base case: if we've reached the end of the permutation, add it to the result
        if (i == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        // Try each element in the input array
        for (int j = 0; j < nums.length; ++j) {
            // If the element has not been used yet, use it and recurse
            if (!vis[j]) {
                vis[j] = true;
                t.add(nums[j]);
                dfs(i + 1);
                // Backtrack: remove the element from the current permutation and mark it as unused
                t.remove(t.size() - 1);
                vis[j] = false;
            }
        }
    }
}