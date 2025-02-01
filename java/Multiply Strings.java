// Multiply Strings - 43

class Solution {
    public String multiply(String num1, String num2) {
        
        // Handle edge case where either input is "0"
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        // Get lengths of input strings
        int m = num1.length(), n = num2.length();

        // Initialize result array with size m + n
        int[] arr = new int[m + n];

        // Perform multiplication digit by digit
        for (int i = m - 1; i >= 0; --i) {
            // Convert current digit of num1 to int
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; --j) {
                // Convert current digit of num2 to int
                int b = num2.charAt(j) - '0';
                // Multiply current digits and add to result array
                arr[i + j + 1] += a * b;
            }
        }

        // Handle carry-over digits
        for (int i = arr.length - 1; i > 0; --i) {
            // Add carry to previous digit
            arr[i - 1] += arr[i] / 10;
            // Keep only last digit
            arr[i] %= 10;
        }

        // Find starting index of result string (skip leading zeros)
        int i = arr[0] == 0 ? 1 : 0;

        // Build result string using StringBuilder
        StringBuilder ans = new StringBuilder();
        for (; i < arr.length; ++i) {
            ans.append(arr[i]);
        }

        // Convert StringBuilder to String and return
        return ans.toString();
    }
}