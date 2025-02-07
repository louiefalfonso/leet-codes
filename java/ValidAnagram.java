/*
Valid Anagram - 49

Given two strings s and t, return true if the two strings are anagrams of each other, 
otherwise return false.

An anagram is a string that contains the exact same characters as another string, 
but the order of the characters can be different.

Input: s = "racecar", t = "carrace"
Output: true

Input: s = "jar", t = "jam"
Output: false

 */

import java.util.HashMap;
import java.util.Map;

class Solution {

   
     //Returns whether two strings are anagrams of each other.

    public boolean isAnagram(String s, String t) {
        // If the strings have different lengths, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Map to store the count of each character in both strings
        Map<Character, Integer> count = new HashMap<>();

        // Iterate over both strings simultaneously and update the character counts
        for (int i = 0; i < s.length(); i++) {
            // Increment the count of the current character in string s
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);

            // Decrement the count of the current character in string t
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) - 1);
        }

        // If the strings are anagrams, all character counts should be zero
        for (int v : count.values()) {
            // If any count is non-zero, the strings are not anagrams
            if (v != 0) {
                return false;
            }
        }

        // If all counts are zero, the strings are anagrams
        return true;
    }
}