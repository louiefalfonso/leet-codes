// Count Subarrays With Fixed Bounds - 2444

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long subArrays = 0;
        int j1 = -1, j2 = -1, k = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                k = i;
            }
            if (nums[i] == minK) {
                j1 = i;
            }
            if (nums[i] == maxK) {
                j2 = i;
            }
            subArrays += Math.max(0, Math.min(j1, j2) - k);
        }
        return subArrays;
    }
}