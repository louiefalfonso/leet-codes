// Minimum Length of String After Operations - 3223

class Solution {
   
    public int minimumLength(String s) {
        // Create an array to count the frequency of each character in the string.
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            // Increment the count of the current character.
            ++cnt[s.charAt(i) - 'a'];
        }
        int ans = 0;
        // Iterate over the count array and calculate the minimum length required to make each
        // character occur an even number of times.
        for (int x : cnt) {
            // If the count of a character is greater than 0, it means that character needs to
            // be removed from the string.
            if (x > 0) {
                // If the count of a character is odd, we need to remove one character. If the
                // count is even, we can remove two characters.
                ans += x % 2 == 1 ? 1 : 2;
            }
        }
        return ans;
    }
}