/*
 * Intersection of Two Arrays - 349
 */

 import java.util.ArrayList;
 import java.util.List;
 
 class Solution {
    // Finds the intersection of two arrays, i.e., elements that appear in both
    // arrays.
    public int[] intersection(int[] nums1, int[] nums2) {
        // Initialize a boolean array to track which elements from nums1 have been seen.
        boolean[] seen = new boolean[1001]; // Assumes the elements are in the range [0, 1000].

        // Mark elements present in nums1 as seen.
        for (int num : nums1) {
            seen[num] = true;
        }

        // Use a list to collect the intersection elements.
        List<Integer> intersectionElements = new ArrayList<>();

        // Iterate over nums2 to find common elements.
        for (int num : nums2) {
            // If an element from nums2 has been seen and is not yet included in the
            // intersectionElements.
            if (seen[num]) {
                intersectionElements.add(num); // Add the element to the intersection list.
                seen[num] = false; // Mark it as not seen to avoid duplicates in the intersectionElements.
            }
        }

        // Convert the List of Integer to an array of int for the result.
        int[] result = new int[intersectionElements.size()];
        for (int i = 0; i < intersectionElements.size(); i++) {
            result[i] = intersectionElements.get(i);
        }

        // Return the result array containing the intersection of the two arrays.
        return result;
    }
}