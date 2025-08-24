// Longest Subarray of 1's After Deleting One Element - 1493

class Solution {
    public int longestSubarray(int[] nums) {
        int length = nums.length;

        int[] leftOnesCount = new int[length];
        int[] rightOnesCount = new int[length];

         for (int i = 1; i < length; ++i) {
            if (nums[i - 1] == 1) {
                leftOnesCount[i] = leftOnesCount[i - 1] + 1;
            }
        }

        for (int i = length - 2; i >= 0; --i) {
            if (nums[i + 1] == 1) {
                rightOnesCount[i] = rightOnesCount[i + 1] + 1;
            }
        }

        int maxSubarrayLength = 0;

        for (int i = 0; i < length; ++i) {
            maxSubarrayLength = Math.max(maxSubarrayLength, leftOnesCount[i] + rightOnesCount[i]);
        }

        if (maxSubarrayLength == length) {
            maxSubarrayLength--;
        }

        return maxSubarrayLength;
    }
}