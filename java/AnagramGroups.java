/*
Anagram Groups

Given an array of strings strs, group all anagrams together into sublists. 
You may return the output in any order.

An anagram is a string that contains the exact same characters as another string, 
but the order of the characters can be different.

Input: strs = ["act","pots","tops","cat","stop","hat"]
Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());

    }
}
