// Contains Duplicate - 217

import java.util.HashSet;
import java.util.Set;

class Solution {
    
    public boolean hasDuplicate(int[] nums) {
        // Create a set to store unique elements from the array
        Set<Integer> set = new HashSet<>();

        // Iterate through each element in the array
        for (int num : nums) {
            // Attempt to add the current element to the set
            // If the element is already present in the set, add() will return false
            if (!set.add(num)) {
                // If add() returns false, it means we've found a duplicate, so return true
                return true;
            }
        }
        // If we've iterated through the entire array without finding any duplicates,
        // return false
        return false;
    }
}