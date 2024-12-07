/*
 * Find the Difference of Two Arrays - 2215
 * 
 1. Use Sets for Uniqueness:
Convert both arrays into sets to automatically handle duplicates and allow for efficient lookups.

2.Find Unique Elements:
Use set operations to find elements that are in one set but not in the other.
Specifically, use the removeAll method to find the difference between the two sets.

3.Return the Result:
Return the results as a list of two lists.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Create sets from the input arrays
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        // Find unique elements in nums1 not in nums2
        Set<Integer> uniqueInNums1 = new HashSet<>(set1);
        uniqueInNums1.removeAll(set2);

        // Find unique elements in nums2 not in nums1
        Set<Integer> uniqueInNums2 = new HashSet<>(set2);
        uniqueInNums2.removeAll(set1);

        // Prepare the result
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(uniqueInNums1));
        result.add(new ArrayList<>(uniqueInNums2));

        return result;
    }
}