class MyQueue {
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        stk1.push(x);
    }
    
    public int pop() {
        if(stk2.size() == 0)
            while(stk1.size() > 0) stk2.push(stk1.pop());
        return stk2.pop();
    }
    
    public int peek() {
        if(stk2.size() == 0)
            while(stk1.size() > 0) stk2.push(stk1.pop());
        return stk2.peek();
    }
    
    public boolean empty() {
        return stk1.size() + stk2.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */