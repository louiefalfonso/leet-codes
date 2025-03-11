// Number of Substrings Containing All Three Characters - 1358

class Solution {
    public int numberOfSubstrings(String s) {

        // Initialize an array to store the last seen index of each character 'a', 'b', and 'c'
        int[] d = new int[] { -1, -1, -1 };
        int ans = 0;

        for (int i = 0; i < s.length(); ++i) {
            
            char c = s.charAt(i);
            // Update the last seen index of the current character
            d[c - 'a'] = i;

            // Calculate the minimum last seen index of 'a', 'b', and 'c'
            // This represents the starting index of the shortest substring that contains
            // all three characters
            // Add the length of this substring (plus 1) to the answer
            ans += Math.min(d[0], Math.min(d[1], d[2])) + 1;
        }
        return ans;
    }
}