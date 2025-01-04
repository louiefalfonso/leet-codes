/*
 * Median of Two Sorted Arrays - 4
 */

 class Solution {
    // Variables to store the length of nums1 and nums2
    private int m;
    private int n;
    // Variables to store the arrays nums1 and nums2
    private int[] nums1;
    private int[] nums2;

    // Function to find the median of two sorted arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Assigning the lengths of nums1 and nums2 to m and n
        m = nums1.length;
        n = nums2.length;
        // Assigning nums1 and nums2 to the instance variables
        this.nums1 = nums1;
        this.nums2 = nums2;
        // Calculating the median by calling the f function
        int a = f(0, 0, (m + n + 1) / 2);
        int b = f(0, 0, (m + n + 2) / 2);
        // Returning the average of a and b
        return (a + b) / 2.0;
    }

    // Recursive function to find the kth smallest element in the merged array
    private int f(int i, int j, int k) {
        // Base case: if i is greater than or equal to m, return the (j + k - 1)th
        // element of nums2
        if (i >= m) {
            return nums2[j + k - 1];
        }
        // Base case: if j is greater than or equal to n, return the (i + k - 1)th
        // element of nums1
        if (j >= n) {
            return nums1[i + k - 1];
        }
        // Base case: if k is 1, return the minimum of the first elements of nums1 and
        // nums2
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        // Calculating the pivot index
        int p = k / 2;
        // Finding the (i + p - 1)th element of nums1 or 1 << 30 if out of bounds
        int x = i + p - 1 < m ? nums1[i + p - 1] : 1 << 30;
        // Finding the (j + p - 1)th element of nums2 or 1 << 30 if out of bounds
        int y = j + p - 1 < n ? nums2[j + p - 1] : 1 << 30;
        // Recursively calling f with appropriate arguments based on the comparison of x
        // and y
        return x < y ? f(i + p, j, k - p) : f(i, j + p, k - p);
    }
}