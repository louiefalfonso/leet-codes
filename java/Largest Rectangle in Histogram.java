// Largest Rectangle in Histogram - 84

 import java.util.Stack;

 class Solution {
     
     public int largestRectangleArea(int[] heights) {

         // Initialize the maximum area to 0
         int maxArea = 0;

         // Initialize arrays to store the indices of the left and right smaller bars
         int[] leftSmaller = new int[heights.length];
         int[] rightSmaller = new int[heights.length];

         // Initialize a stack to keep track of the indices of the bars
         Stack<Integer> stack = new Stack<>();

         // Iterate over the histogram bars from left to right
         for (int i = 0; i < heights.length; i++) {
             // While the stack is not empty and the current bar is smaller than the bar at
             // the top of the stack,
             // pop the stack and update the leftSmaller array
             while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                 stack.pop();
             }
             // If the stack is empty, the leftSmaller index is -1, otherwise it's the index
             // of the bar at the top of the stack
             leftSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
             // Push the current index onto the stack
             stack.push(i);
         }

         // Clear the stack for the next iteration
         stack.clear();

         // Iterate over the histogram bars from right to left
         for (int i = heights.length - 1; i >= 0; i--) {
             // While the stack is not empty and the current bar is smaller than the bar at
             // the top of the stack,
             // pop the stack and update the rightSmaller array
             while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                 stack.pop();
             }
             // If the stack is empty, the rightSmaller index is the length of the heights
             // array, otherwise it's the index of the bar at the top of the stack
             rightSmaller[i] = stack.isEmpty() ? heights.length : stack.peek();
             // Push the current index onto the stack
             stack.push(i);
         }

         // Iterate over the histogram bars and calculate the area of the rectangle with
         // the current bar as the smallest bar
         for (int i = 0; i < heights.length; i++) {
             // Update the maximum area if the current area is larger
             maxArea = Math.max(maxArea, heights[i] * (rightSmaller[i] - leftSmaller[i] - 1));
         }
         // Return the maximum area
         return maxArea;
     }
 }