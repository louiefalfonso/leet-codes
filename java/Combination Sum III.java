/*
 * Combination Sum III - 216
 */

 import java.util.ArrayList;
 import java.util.List;
 
 class Solution {
    // List to store the final combinations
    private List<List<Integer>> combinations = new ArrayList<>();
    // Temporary list for the current combination
    private List<Integer> currentCombination = new ArrayList<>();
    // The number of numbers to use in each combination
    private int combinationLength;

    // The public method that initiates the combination search
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.combinationLength = k;
        searchCombinations(1, n);
        return combinations;
    }

    // Helper method to perform depth-first search for combinations
    private void searchCombinations(int start, int remainingSum) {
        // If remaining sum is zero and the current combination's size is k
        if (remainingSum == 0) {
            if (currentCombination.size() == combinationLength) {
                // Found a valid combination, add a copy to the result list
                combinations.add(new ArrayList<>(currentCombination));
            }
            return; // Backtrack
        }
        // If the current number exceeds 9, the remaining sum, or if we have enough
        // numbers in the current combination
        if (start > 9 || start > remainingSum || currentCombination.size() >= combinationLength) {
            return; // Cannot find a valid combination from here, backtrack
        }
        // Include 'start' in the current combination
        currentCombination.add(start);
        // Continue to the next number with the updated remaining sum
        searchCombinations(start + 1, remainingSum - start);
        // Exclude 'start' from the current combination (backtrack)
        currentCombination.remove(currentCombination.size() - 1);
        // Continue to the next number without including 'start'
        searchCombinations(start + 1, remainingSum);
    }
}
