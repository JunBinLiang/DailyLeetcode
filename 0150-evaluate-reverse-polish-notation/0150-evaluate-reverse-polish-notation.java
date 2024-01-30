class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int x = stk.pop(), y = stk.pop();
                if(s.equals("+")) stk.push(x + y);
                if(s.equals("-")) stk.push(y - x);
                if(s.equals("*")) stk.push(x * y);
                if(s.equals("/")) stk.push(y / x);
                
            } else {
                stk.push(Integer.parseInt(s));
            }
        }
        return stk.peek();
    }
}