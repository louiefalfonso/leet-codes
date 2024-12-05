/*
 * Is Subsequence - 392
 */


 class Solution {
    public boolean isSubsequence(String s, String t) {
        // Lengths of the strings s and t
        int lengthS = s.length(), lengthT = t.length();

        // Initialize pointers for both the strings
        int indexS = 0, indexT = 0;

        // Iterate over both strings
        while (indexS < lengthS && indexT < lengthT) {
            // Check if the current character of s matches the current character of t
            if (s.charAt(indexS) == t.charAt(indexT)) {
                // If they match, move the pointer of s forward
                ++indexS;
            }
            // Move the pointer of t forward
            ++indexT;
        }

        // If indexS is equal to the length of s, all characters of s are found in t in
        // sequence
        // Therefore, s is a subsequence of t
        return indexS == lengthS;
    }
}
