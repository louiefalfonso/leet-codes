// Find Unique Binary String - 1980

class Solution {
   
    // Finds a binary string that is different from all strings in the input array.
    public String findDifferentBinaryString(String[] nums) {
        
        // Create a mask to keep track of the counts of '1's in the input strings
        int mask = 0;

        // Iterate over each string in the input array
        for (var x : nums) {
            // Count the number of '1's in the current string
            int cnt = 0;
            for (int i = 0; i < x.length(); ++i) {
                if (x.charAt(i) == '1') {
                    ++cnt;
                }
            }
            // Update the mask with the count of '1's
            mask |= 1 << cnt;
        }

        // Find the first count that is not present in the mask
        for (int i = 0;; ++i) {
            // Check if the current count is not present in the mask
            if ((mask >> i & 1) == 0) {
                // Return a binary string with '1's repeated i times and '0's repeated for the
                // remaining length
                return "1".repeat(i) + "0".repeat(nums.length - i);
            }
        }
    }
}