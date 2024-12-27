/*
 * Alien Dictionary - 269
 */

 import java.util.*;
 
 class Solution {
    public String alienOrder(String[] words) {
        // Graph represented as a 2D boolean array; g represents the edges.
        boolean[][] graph = new boolean[26][26];
        // Seen array to keep track of the characters encountered in the words.
        boolean[] seen = new boolean[26];
        // Counter for the number of unique letters.
        int uniqueLettersCount = 0;
        int totalWords = words.length;

        // First, process all the words except the last one for building the graph.
        for (int i = 0; i < totalWords - 1; ++i) {
            for (char c : words[i].toCharArray()) {
                if (uniqueLettersCount == 26) {
                    break;
                }
                int index = c - 'a';
                if (!seen[index]) {
                    ++uniqueLettersCount;
                    seen[index] = true;
                }
            }

            // Build the graph based on the given dictionary (words array).
            int wordLength = words[i].length();
            for (int j = 0; j < wordLength; ++j) {
                if (j >= words[i + 1].length()) {
                    return ""; // If the next word is a prefix of the current word, it is invalid.
                }

                char currentChar = words[i].charAt(j), nextChar = words[i + 1].charAt(j);
                if (currentChar == nextChar) {
                    continue; // No specific order is extracted from this character comparison.
                }

                // Detect cycle or invalid sequence.
                if (graph[nextChar - 'a'][currentChar - 'a']) {
                    return "";
                }
                // Establish the edge relationship in the graph.
                graph[currentChar - 'a'][nextChar - 'a'] = true;
                break;
            }
        }

        // Process the last word to account for its letters.
        for (char c : words[totalWords - 1].toCharArray()) {
            if (uniqueLettersCount == 26) {
                break;
            }
            int index = c - 'a';
            if (!seen[index]) {
                ++uniqueLettersCount;
                seen[index] = true;
            }
        }

        // Compute the in-degree for each node/character in the graph.
        int[] inDegree = new int[26];
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                if (i != j && seen[i] && seen[j] && graph[i][j]) {
                    ++inDegree[j];
                }
            }
        }

        // Queue for topological sorting (Kahn's algorithm).
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 26; ++i) {
            if (seen[i] && inDegree[i] == 0) {
                queue.offerLast(i); // Enqueue characters with in-degree of 0.
            }
        }

        // Perform topological sort to determine the alien language order.
        StringBuilder alienOrder = new StringBuilder();
        while (!queue.isEmpty()) {
            int current = queue.pollFirst();
            alienOrder.append((char) (current + 'a'));
            for (int i = 0; i < 26; ++i) {
                if (i != current && seen[i] && graph[current][i]) {
                    // Decrement in-degree and enqueue if in-degree becomes 0.
                    if (--inDegree[i] == 0) {
                        queue.offerLast(i);
                    }
                }
            }
        }
        // If the final sorted string has a length less than the count of unique
        // letters, there is an inconsistency.
        return alienOrder.length() < uniqueLettersCount ? "" : alienOrder.toString();
    }
}