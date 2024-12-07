/*
 * Unique Number of Occurrences - 1207
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

 class Solution {
    // This method checks if all elements in the array have unique occurrence
    // counts.
    public boolean uniqueOccurrences(int[] arr) {
        // Create a hashmap to store the counts of each number.
        Map<Integer, Integer> countMap = new HashMap<>();

        // Iterate over the array and populate the countMap.
        for (int number : arr) {
            // If the number is already in the map, increment its count, otherwise insert it
            // with count 1.
            countMap.merge(number, 1, Integer::sum);
        }

        // Create a hashset containing all the values (occurrence counts) from the
        // countMap.
        Set<Integer> occurrenceSet = new HashSet<>(countMap.values());

        // If the size of the set (unique occurrences) is the same as the size of the
        // map (unique numbers),
        // it means that all occurrence counts are unique and we return true. Otherwise,
        // return false.
        return occurrenceSet.size() == countMap.size();
    }
}