/*
 Rearranging a Word

 Given two strings, you need to determine if they can be rearranged to form the same word, 
 i.e., if they are anagrams of each other.

 Input: word1 = "abc", word2 = "bca"
 Output: true

 Input: word1 = "abc", word2 = "bad"
 Output: false
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RearrangingAWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the two strings
        System.out.println("Enter first word:");
        String firstWord = scanner.nextLine().trim();
        System.out.println("Enter second word:");
        String secondWord = scanner.nextLine().trim();

        // Check if they are anagrams
        if (areAnagrams(firstWord, secondWord)) {
            System.out.println("The words are anagrams.");
        } else {
            System.out.println("The words are not anagrams.");
        }

        scanner.close();
    }

    private static boolean areAnagrams(String first, String second) {
        // If lengths are different, they cannot be anagrams
        if (first.length() != second.length()) {
            return false;
        }

        // Create a map to count characters
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Count characters in the first word
        for (char c : first.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Subtract counts based on the second word
        for (char c : second.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false; // Character not found in the first word
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if (charCountMap.get(c) < 0) {
                return false; // More occurrences in the second word
            }
        }

        return true; // If all counts are zero, they are anagrams
    }
}