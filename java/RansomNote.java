// Ransom Note - 383

class Solution {
    
     // Returns whether the ransom note can be constructed from the magazine.
    public boolean canConstruct(String ransomNote, String magazine) {
        // Create a frequency array to count the occurrences of each letter in the
        // magazine
        int[] cnt = new int[26];

        // Count the occurrences of each letter in the magazine
        for (int i = 0; i < magazine.length(); ++i) {
            // Convert the character to its corresponding index in the frequency array
            // by subtracting the ASCII value of 'a'
            ++cnt[magazine.charAt(i) - 'a'];
        }

        // Try to construct the ransom note from the magazine
        for (int i = 0; i < ransomNote.length(); ++i) {
            // If the current letter in the ransom note is not available in the magazine,
            // return false
            if (--cnt[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        // If all letters in the ransom note can be constructed from the magazine,
        // return true
        return true;
    }
}