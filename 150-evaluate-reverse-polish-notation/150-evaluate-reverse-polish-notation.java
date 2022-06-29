class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> expression = new Stack<Integer>();
        for (String token : tokens) {
            if (isOperator(token)) {
                Integer b = expression.pop();
                Integer a = expression.pop();
                expression.add(solve(a, b, token));
            } else {
                expression.add(Integer.parseInt(token));
            }
        }
        return expression.pop();
    }
    
    public boolean isOperator(String token) {
        return token.equals("+")
            || token.equals("-")
            || token.equals("*")
            || token.equals("/");
    }
    
    public int solve(int a, int b, String operator) {
        switch(operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        
        return 0;
    }
}