/*
 Container With Most Water

 You are given an integer array heights where heights[i] represents the height of the ith bar of a bar chart.

You may choose any two bars to form a container. Return the maximum amount of water a container can store.

Example 1:
Input: height = [1,7,2,5,4,7,3,6]
Output: 36

Example 2:
Input: height = [4,3,2,1,4]
Output: 16
 */


class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0; // Variable to store the maximum area

        // Brute force approach: check every pair of lines
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                // Calculate width and height
                int width = j - i;
                int currentHeight = Math.min(height[i], height[j]);
                // Calculate area
                int currentArea = width * currentHeight;
                // Update maxArea if currentArea is larger
                maxArea = Math.max(maxArea, currentArea);
            }
        }

        return maxArea; // Return the maximum area found
    }
}