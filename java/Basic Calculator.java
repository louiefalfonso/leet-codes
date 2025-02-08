// Basic Calculator - 224
import java.util.ArrayDeque;
import java.util.Deque;



 // Basic Calculator.
 // This class provides a method to calculate the result of a basic arithmetic expression.
class Solution {

    
    // Calculates the result of the given arithmetic expression.
    public int calculate(String s) {
        
        // Stack to store intermediate results and signs
        Deque<Integer> stk = new ArrayDeque<>();

        // Sign of the current number (1 for positive, -1 for negative)
        int sign = 1;
        
        // Current result
        int ans = 0;
        
        // Length of the input string
        int n = s.length();

        // Iterate through the input string
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            
            // If the current character is a digit, parse the entire number
            if (Character.isDigit(c)) {
                int j = i;
                int x = 0;
                // Parse the number by iterating through consecutive digits
                while (j < n && Character.isDigit(s.charAt(j))) {
                    x = x * 10 + s.charAt(j) - '0';
                    j++;
                }
                // Add the number to the current result with the correct sign
                ans += sign * x;
                // Move the index to the last digit of the number
                i = j - 1;
            } 
            // If the current character is a '+' sign, update the sign
            else if (c == '+') {
                sign = 1;
            } 
            // If the current character is a '-' sign, update the sign
            else if (c == '-') {
                sign = -1;
            } 
            // If the current character is an opening parenthesis, push the current result and sign to the stack
            else if (c == '(') {
                stk.push(ans);
                stk.push(sign);
                // Reset the current result and sign
                ans = 0;
                sign = 1;
            } 
            // If the current character is a closing parenthesis, pop the last result and sign from the stack
            else if (c == ')') {
                // Calculate the result inside the parentheses and add it to the previous result
                ans = stk.pop() * ans + stk.pop();
            }
        }
        // Return the final result
        return ans;
    }
}```