/*
 Trapping Rain Water

 You are given an array non-negative integers height which represent an elevation map. 
 Each value height[i] represents the height of a bar, which has a width of 1.
 
 Return the maximum area of water that can be trapped between the bars.

 Example 1:
 Input: height = [0,2,0,3,1,0,1,3,2,1]
 Output: 9

 Example 2:
 Input: height = [4,2,0,3,2,5]
 Output: 9

 */

 class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int totalWater = 0;

        // Iterate through each bar in the height array
        for (int i = 0; i < n; i++) {
            
            // Find the maximum height to the left of the current bar
            int leftMax = 0;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // Find the maximum height to the right of the current bar
            int rightMax = 0;
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            // Calculate the water trapped on top of the current bar
            int waterAtCurrentBar = Math.min(leftMax, rightMax) - height[i];

            // If waterAtCurrentBar is positive, add it to the total
            if (waterAtCurrentBar > 0) {
                totalWater += waterAtCurrentBar;
            }
        }

        return totalWater; // Return the total water trapped
    }
}
