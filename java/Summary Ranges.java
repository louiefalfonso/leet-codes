// Summary Ranges - 228

import java.util.ArrayList;
import java.util.List;

class Solution {
    // Method to generate a summary of ranges from the array.
    public List<String> summaryRanges(int[] nums) {
        // Initialize a list to store the resulting summary of ranges.
        List<String> result = new ArrayList<>();

        // Iterate through the elements of the array to find consecutive ranges.
        for (int startIndex = 0, endIndex, n = nums.length; startIndex < n; startIndex = endIndex + 1) {
            // Initialize the end index of the range to the current start index.
            endIndex = startIndex;

            // Expand the range while the next number is consecutive.
            while (endIndex + 1 < n && nums[endIndex + 1] == nums[endIndex] + 1) {
                endIndex++;
            }

            // Add the current range to the result list.
            result.add(createRangeString(nums, startIndex, endIndex));
        }
        // Return the list containing all the summary ranges.
        return result;
    }

    // Helper method to format the range into a string.
    private String createRangeString(int[] nums, int start, int end) {
        // If the start index and end index are the same, return just one number.
        // Otherwise, return the formatted string representing the range.
        return start == end ? Integer.toString(nums[start]) : String.format("%d->%d", nums[start], nums[end]);
    }
}
