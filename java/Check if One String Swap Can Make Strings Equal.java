// Check if One String Swap Can Make Strings Equal - 1790

class Solution {
    
     // Checks if two strings are almost equal, meaning they differ by at most two characters.
    public boolean areAlmostEqual(String s1, String s2) {
        
        // Count the number of differing characters
        int cnt = 0;

        // Store the differing characters
        char c1 = 0, c2 = 0;

        // Iterate over the characters in the strings
        for (int i = 0; i < s1.length(); ++i) {
            char a = s1.charAt(i), b = s2.charAt(i);

            // If the characters differ
            if (a != b) {
                // If there are more than two differing characters, or if the differing
                // characters are not a swap, return false
                if (++cnt > 2 || (cnt == 2 && (a != c2 || b != c1))) {
                    return false;
                }

                // Store the differing characters
                c1 = a;
                c2 = b;
            }
        }

        // If there is exactly one differing character, the strings are not almost equal
        // If there are zero or two differing characters, the strings are almost equal
        return cnt != 1;
    }
}