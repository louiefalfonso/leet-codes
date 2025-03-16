// Zero Array Transformation II - 3356

class Solution {
    private int n; // Length of the nums array
    private int[] nums; // Array of numbers to be transformed
    private int[][] queries; // Array of queries, each containing [l, r, val]

    // Method to find the minimum number of queries needed to transform the nums array to a zero array
    public int minZeroArray(int[] nums, int[][] queries) {
        this.nums = nums;
        this.queries = queries;
        n = nums.length; // Initialize n with the length of nums
        int m = queries.length; // Number of queries
        int l = 0, r = m + 1; // Binary search boundaries

        // Perform binary search to find the minimum number of queries
        while (l < r) {
            int mid = (l + r) >> 1; // Calculate mid-point
            if (check(mid)) { // Check if the first 'mid' queries can transform nums to zero array
                r = mid; // If yes, try fewer queries
            } else {
                l = mid + 1; // If no, try more queries
            }
        }
        return l > m ? -1 : l; // Return -1 if not possible, otherwise return the minimum number of queries
    }

    // Helper method to check if the first 'k' queries can transform nums to zero array
    private boolean check(int k) {
        int[] d = new int[n + 1]; // Difference array for range updates
        for (int i = 0; i < k; ++i) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            d[l] += val; // Increment start of range
            d[r + 1] -= val; // Decrement end of range + 1
        }
        for (int i = 0, s = 0; i < n; ++i) {
            s += d[i]; // Accumulate the difference array
            if (nums[i] > s) { // If nums[i] is greater than the accumulated sum, transformation is not possible
                return false;
            }
        }
        return true; // Transformation is possible
    }
}
}