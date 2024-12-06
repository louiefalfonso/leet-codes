/*
 * Maximum Number of Vowels in a Substring of Given Length - 1456
 */

 class Solution {
    
    public boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    public int maxVowels(String s, int k) {
        if (s.length() < k)
            return 0;
        int max = 0, n = s.length();
        int count = 0;

        // Count vowels in the first window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i)))
                count++;
        }
        max = count;

        // Slide the window
        for (int i = k; i < n; i++) {
            // Remove the contribution of the (i - k)th character
            if (isVowel(s.charAt(i - k)))
                count--;
            // Add the contribution of the current character
            if (isVowel(s.charAt(i)))
                count++;
            // Update max
            max = Math.max(max, count);
        }
        return max;
    }
}