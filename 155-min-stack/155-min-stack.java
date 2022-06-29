class MinStack {
    
    Stack<Pair<Integer, Integer>> mainStack;

    public MinStack() {
        mainStack = new Stack<>();
    }
    
    public void push(int val) {
        if (mainStack.isEmpty() || val <= mainStack.peek().getValue())
            mainStack.push(new Pair<>(val, val));
        else
            mainStack.push(new Pair<>(val, mainStack.peek().getValue()));
    }
    
    public void pop() {
        mainStack.pop();
    }
    
    public int top() {
        return mainStack.peek().getKey();
    }
    
    public int getMin() {
        return mainStack.peek().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */