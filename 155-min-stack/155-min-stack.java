class MinStack {

    Stack<Integer> data;
    Stack<Integer> min;
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        if(data.size() == 0 && min.size() == 0){
            min.push(val);
        }else if(min.peek() >= val){
            min.push(val);
        }
        
        data.push(val);
    }
    
    public void pop() {
        if(data.peek().equals(min.peek())){
            min.pop();
        }
        data.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return min.peek();
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