
 // Minimum Window Substring - 76

 class Solution {
    
    public String minWindow(String s, String t) {

        // Create frequency arrays for characters in `t` and the current window
        int[] need = new int[128]; // frequency of characters in `t`
        int[] window = new int[128]; // frequency of characters in the current window

        // Initialize `need` array with frequencies of characters in `t`
        for (char c : t.toCharArray()) {
            ++need[c];
        }

        // Initialize variables to keep track of the minimum window
        int m = s.length(), n = t.length();
        int k = -1, mi = m + 1, cnt = 0; // k: start index of min window, mi: min window length, cnt: number of
                                         // characters in `t` found in the current window

        // Iterate over the string `s` to find the minimum window
        for (int l = 0, r = 0; r < m; ++r) {
            char c = s.charAt(r);
            // If the current character is in `t` and its frequency in the window is less
            // than or equal to its frequency in `t`, increment the count
            if (++window[c] <= need[c]) {
                ++cnt;
            }

            // If all characters in `t` are found in the current window, try to minimize the
            // window
            while (cnt == n) {
                // Update the minimum window if the current window is smaller
                if (r - l + 1 < mi) {
                    mi = r - l + 1;
                    k = l;
                }

                // Remove the leftmost character from the window
                c = s.charAt(l);
                if (window[c] <= need[c]) {
                    --cnt;
                }
                --window[c];
                ++l;
            }
        }

        // Return the minimum window substring or an empty string if no such window
        // exists
        return k < 0 ? "" : s.substring(k, k + mi);
    }
}