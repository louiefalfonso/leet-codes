/*
 * Check If N and Its Double Exist - 1346
 */

 import java.util.HashMap;
 import java.util.Map;
 
 class Solution {

    // Checks if the array contains any duplicate elements where one element
    // is twice as much as another element
    public boolean checkIfExist(int[] arr) {

        // Create a HashMap to store the array elements with their corresponding index.
        Map<Integer, Integer> elementToIndexMap = new HashMap<>();

        // Get the length of the array to iterate
        int length = arr.length;

        // Populate the HashMap with array elements as keys and their indices as values
        for (int index = 0; index < length; ++index) {
            elementToIndexMap.put(arr[index], index);
        }

        // Iterate over the array to find a duplicate where one number is double the
        // other
        for (int index = 0; index < length; ++index) {
            // Calculate the double of the current element
            int doubleValue = arr[index] * 2;

            // Check if the double of this number exists in the map and it's not the number
            // itself
            if (elementToIndexMap.containsKey(doubleValue) && elementToIndexMap.get(doubleValue) != index) {
                return true; // Found the pair where one is double the other
            }
        }

        // If no such pair exists, return false
        return false;
    }
}