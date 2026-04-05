class MinStack {

    private Deque<Integer> data = new ArrayDeque<>();
    private Deque<Integer> q = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        data.push(val);
        if(data.size() ==1){
            q.push(val);
            return;
        }
        q.push(Math.min(val, q.peek()));
    }
    
    public void pop() {
        q.pop();
        data.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return q.peek();
    }
}
