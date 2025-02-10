// Subsets II - 90

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    // Store the result subsets
    private List<List<Integer>> ans = new ArrayList<>();
    // Temporary list to store current subset
    private List<Integer> t = new ArrayList<>();
    // Input array
    private int[] nums;

    // Main function to generate subsets with duplicates
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort the input array to handle duplicates
        Arrays.sort(nums);
        this.nums = nums;
        // Start DFS from index 0
        dfs(0);
        return ans;
    }

    // Depth-First Search function
    private void dfs(int i) {
        // Base case: if we've reached the end of the array
        if (i >= nums.length) {
            // Add the current subset to the result
            ans.add(new ArrayList<>(t));
            return;
        }
        // Add the current element to the subset
        t.add(nums[i]);
        // Recur for the next element
        dfs(i + 1);
        // Remove the last added element (backtracking)
        int x = t.remove(t.size() - 1);
        // Skip duplicates by incrementing the index
        while (i + 1 < nums.length && nums[i + 1] == x) {
            ++i;
        }
        // Recur for the next element (skipping duplicates)
        dfs(i + 1);
    }
}