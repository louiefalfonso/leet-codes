// Min Stack - 155

class MinStack {
    // stk1 keeps track of all the elements in the stack.
    private Deque<Integer> stack = new ArrayDeque<>();

    // minValuesStack keeps track of the minimum values at each state of the stack.
    private Deque<Integer> minValuesStack = new ArrayDeque<>();

    // Constructor initializes the minValuesStack with the maximum value an integer can hold.
    public MinStack() {
        minValuesStack.push(Integer.MAX_VALUE);
    }

    // Method to push an element onto the stack. Updates the minimum value as well.
    public void push(int val) {
        // Push the value onto the stack.
        stack.push(val);
        // Push the smaller between the current value and the current minimum onto the minValuesStack.
        minValuesStack.push(Math.min(val, minValuesStack.peek()));
    }

    // Method to remove the top element from the stack. Also updates the minimum value.
    public void pop() {
        // Remove the top element of the stack.
        stack.pop();
        // Remove the top element of the minValuesStack, which corresponds to the minimum at that state.
        minValuesStack.pop();
    }

    // Method to retrieve the top element of the stack without removing it.
    public int top() {
        // Peek the top element of the stack.
        return stack.peek();
    }

    // Method to get the current minimum value in the stack.
    public int getMin() {
        // Peek the top element of the minValuesStack, which is the current minimum.
        return minValuesStack.peek();
    }
}
