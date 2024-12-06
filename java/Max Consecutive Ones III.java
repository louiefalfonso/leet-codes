/*
 * Max Consecutive Ones III - 1004
 
 */

 class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0; // Left pointer of the sliding window
        int maxLength = 0; // To keep track of the maximum length of consecutive 1s
        int zeroCount = 0; // To count the number of 0s in the current window

        for (int right = 0; right < nums.length; right++) {
            // If we encounter a 0, increment the zeroCount
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If the count of 0s exceeds k, move the left pointer
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Calculate the maximum length of the window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}