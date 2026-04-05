class Solution {
    public int evalRPN(String[] tokens) {
        try{
            Integer init = Integer.parseInt(tokens[0]);
        }
        catch(Exception e){
            return 0;
        }
        Deque<Integer> q = new ArrayDeque<>();

        int i = 0;
        while(i<tokens.length){
            String t = tokens[i++];
            switch(t) {
                case "+":
                    int n1 = q.pop();
                    int n2 = q.pop();
                    q.push(n1+n2);
                    break;
                case "-":
                    n1 = q.pop();
                    n2 = q.pop();
                    q.push(n2-n1);
                    break;
                case "/":
                    n1 = q.pop();
                    n2 = q.pop();
                    if(n1==0){
                        n1=1;
                    }
                    q.push(n2/n1);
                    break;
                case "*":
                    n1 = q.pop();
                    n2 = q.pop();
                    q.push(n1*n2);
                    break;
                default:
                  q.push(Integer.parseInt(t));  
            }
        }

        return q.pop();
    }
}
