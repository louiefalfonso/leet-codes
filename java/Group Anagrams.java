// Group Anagrams - 49

import java.util.*;

class Solution {

    //Groups a list of strings into anagrams.
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // Create a map to store the anagrams, where the key is the sorted string and
        // the value is a list of anagrams
        Map<String, List<String>> d = new HashMap<>();

        // Iterate over each string in the input array
        for (String s : strs) {
            // Convert the string to a character array and sort it
            char[] t = s.toCharArray();
            Arrays.sort(t);

            // Convert the sorted character array back to a string to use as a key in the
            // map
            String k = String.valueOf(t);

            // If the key is not already in the map, add it with a new list as its value
            // Then, add the original string to the list of anagrams for this key
            d.computeIfAbsent(k, key -> new ArrayList<>()).add(s);
        }

        // Return a list of the values in the map, which are the lists of anagrams
        return new ArrayList<>(d.values());
    }
}