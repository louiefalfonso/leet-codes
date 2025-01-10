// Evaluate Reverse Polish Notation - 150
import java.util.*;

class Solution {
    
    public int evalRPN(String[] tokens) {
        // Create a stack to store the intermediate results
        Deque<Integer> stk = new ArrayDeque<>();

        // Iterate over each token in the input array
        for (String t : tokens) {
            // Check if the token is a number (either a single digit or multiple digits)
            if (t.length() > 1 || Character.isDigit(t.charAt(0))) {
                // Push the number onto the stack
                stk.push(Integer.parseInt(t));
            } else {
                // The token is an operator, so pop the top two numbers from the stack
                int y = stk.pop();
                int x = stk.pop();

                // Perform the operation based on the operator
                switch (t) {
                    case "+":
                        // Add x and y and push the result back onto the stack
                        stk.push(x + y);
                        break;
                    case "-":
                        // Subtract y from x and push the result back onto the stack
                        stk.push(x - y);
                        break;
                    case "*":
                        // Multiply x and y and push the result back onto the stack
                        stk.push(x * y);
                        break;
                    default:
                        // Divide x by y and push the result back onto the stack
                        // Note: this assumes that the input is well-formed and y is non-zero
                        stk.push(x / y);
                        break;
                }
            }
        }

        // The final result is the only element left on the stack
        return stk.pop();
    }
}