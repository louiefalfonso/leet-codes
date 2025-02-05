// Word Pattern - 290

import java.util.HashMap;
import java.util.Map;

class Solution {
   
     //Checks if a given string follows a certain pattern.
    public boolean wordPattern(String pattern, String s) {
        
        // Split the string into words
        String[] ws = s.split(" ");

        // If the pattern length doesn't match the number of words, return false
        if (pattern.length() != ws.length) {
            return false;
        }

        // Create two maps to store the pattern-word and word-pattern relationships
        Map<Character, String> d1 = new HashMap<>(); // pattern -> word
        Map<String, Character> d2 = new HashMap<>(); // word -> pattern

        // Iterate over the words and pattern characters
        for (int i = 0; i < ws.length; ++i) {
            char a = pattern.charAt(i);
            String b = ws[i];

            // If the pattern-word or word-pattern relationship is inconsistent, return
            // false
            if (!d1.getOrDefault(a, b).equals(b) || d2.getOrDefault(b, a) != a) {
                return false;
            }

            // Update the maps with the current pattern-word and word-pattern relationships
            d1.put(a, b);
            d2.put(b, a);
        }

        // If we've reached this point, the string follows the pattern
        return true;
    }
}