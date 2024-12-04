/*
 Reverse Words in a String -151

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. 
The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. 
The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"
 */

import java.util.*;

 class Solution {

    // Method to reverse the words in a given string 's'
    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing whitespaces
        // and split it into an array of words based on one or more whitespace
        // characters
        String[] wordsArray = s.trim().split("\\s+");

        // Convert the array of words into a list for easy manipulation
        List<String> wordsList = new ArrayList<String>(Arrays.asList(wordsArray));

        // Reverse the order of the words in the list
        Collections.reverse(wordsList);

        // Join the reversed list of words into a single string separated by a single
        // space
        String reversed = String.join(" ", wordsList);

        // Return the reversed string
        return reversed;
    }
}