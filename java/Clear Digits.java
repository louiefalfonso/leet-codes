// Clear Digits - 3174

class Solution {
    public String clearDigits(String s) {
        // Use a StringBuilder to efficiently build the resulting string
        StringBuilder stk = new StringBuilder();

        // Iterate through each character in the input string
        for (char c : s.toCharArray()) {
            // If the character is a digit, remove the last character from the StringBuilder
            if (Character.isDigit(c)) {
                // This effectively "clears" the last non-digit character
                if (stk.length() > 0) {
                    stk.deleteCharAt(stk.length() - 1);
                }
            } else {
                // If the character is not a digit, append it to the StringBuilder
                stk.append(c);
            }
        }

        // Return the resulting string
        return stk.toString();
    }
}