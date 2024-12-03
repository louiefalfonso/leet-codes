/*
 Minimum Window Substring

 Given two strings s and t, return the shortest substring of s such that every character in t, 
 including duplicates, is present in the substring. If such a substring does not exist, 
 return an empty string "".
 
 You may assume that the correct output is always unique.

 Example 1:
 Input: s = "OUZODYXAZV", t = "XYZ"
 Output: "YXAZ"

 Example 2:
 Input: s = "ADOBECODEBANC", t = "ABC"
 Output: "BANC"
 */

 import java.util.HashMap;

 class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        String minSubstring = "";

        // Generate all possible substrings of s
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (containsAllChars(substring, t)) {
                    if (substring.length() < minLength) {
                        minLength = substring.length();
                        minSubstring = substring;
                    }
                }
            }
        }

        return minSubstring;
    }

    // function to check if substring contains all characters of t
    private boolean containsAllChars(String substring, String t) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Count characters in t
        for (char c : t.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Check if substring contains all characters of t
        for (char c : substring.toCharArray()) {
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) - 1);
            }
        }

        // Check if all counts are zero
        for (int count : charCount.values()) {
            if (count > 0) {
                return false;
            }
        }

        return true;
    }
}
