// Zigzag Conversion - 6

class Solution {
    public String convert(String inputString, int numRows) {
        // If numRows is 1, no pattern is required, so return the string as it is.
        if (numRows == 1) {
            return inputString;
        }

        // StringBuilder is more efficient when appending characters in a loop.
        StringBuilder convertedStringBuilder = new StringBuilder();
        // Length of the pattern cycle.
        int cycleLength = 2 * numRows - 2;

        // Loop over each row.
        for (int row = 0; row < numRows; row++) {
            // Calculate the interval for the current row.
            // For the first and last row, it is the cycle length,
            // for the others, it depends on the row number.
            int interval = (row == numRows - 1) ? cycleLength : 2 * (numRows - row - 1);
            // Index to keep track of the position on the string.
            int index = row;

            // Continue looping until the end of the string is reached.
            while (index < inputString.length()) {
                // Append character at index to the result.
                convertedStringBuilder.append(inputString.charAt(index));
                // Proceed to the next character in the current row.
                index += interval;
                // Toggle the interval for the middle rows.
                // This does not affect the first and last rows.
                interval = (interval == cycleLength || interval == 0) ? cycleLength : cycleLength - interval;
            }
        }

        // Convert StringBuilder back to String and return.
        return convertedStringBuilder.toString();
    }
}