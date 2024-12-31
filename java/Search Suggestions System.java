/*
 * Search Suggestions System - 1268
 */

 import java.util.*;
 
 // Trie data structure to hold prefixes and their associated indices
class Trie {
    Trie[] children = new Trie[26]; // Each child represents a letter 'a' to 'z'
    List<Integer> indices = new ArrayList<>(); // List to hold indices of words where this node is a prefix

    // Method to insert a word into the trie
    public void insert(String word, int index) {
        Trie node = this;
        for (int j = 0; j < word.length(); ++j) {
            int charIdx = word.charAt(j) - 'a'; // Calculate index of the character
            if (node.children[charIdx] == null) {
                node.children[charIdx] = new Trie();
            }
            node = node.children[charIdx];
            // Only keep at most 3 indices in the list to meet problem constraints
            if (node.indices.size() < 3) {
                node.indices.add(index);
            }
        }
    }

    // Method to search in the trie and retrieve indices of entries with given
    // prefix
    public List<Integer>[] search(String word) {
        Trie node = this;
        int wordLength = word.length();
        List<Integer>[] searchResults = new List[wordLength];
        Arrays.setAll(searchResults, k -> new ArrayList<>());
        for (int i = 0; i < wordLength; ++i) {
            int charIdx = word.charAt(i) - 'a'; // Calculate index of the character
            if (node.children[charIdx] == null) {
                break; // No further matches, break out of the loop
            }
            node = node.children[charIdx]; // Move to the child node
            searchResults[i] = node.indices; // Add the current node's indices
        }
        return searchResults;
    }
}

class Solution {
    // Method to suggest products based on the current searchWord input
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Sort the products array to ensure the output is lexicographically sorted
        Arrays.sort(products);
        Trie trie = new Trie();

        // Insert all products into the trie
        for (int i = 0; i < products.length; ++i) {
            trie.insert(products[i], i);
        }

        List<List<String>> suggestions = new ArrayList<>(); // Final list to hold the suggestions

        // Search each prefix of the searchWord and construct the final suggestion list
        for (List<Integer> indices : trie.search(searchWord)) {
            List<String> productList = new ArrayList<>();
            for (int index : indices) { // Convert the indices to actual product strings
                productList.add(products[index]);
            }
            suggestions.add(productList);
        }

        return suggestions; // Return the accumulated list of product suggestions
    }
}