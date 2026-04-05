class Solution {
    public boolean isValid(String s) {
        if(s.length()<=1){
            return false;
        }
        Map<Character, Integer> open = new HashMap();
        open.put('(', 1);
        open.put('[', 2);
        open.put('{', 3);

        Map<Character, Integer> close = new HashMap();
        close.put(')', 1);
        close.put(']', 2);
        close.put('}', 3);

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(open.containsKey(c)){
                stack.push(c);
            }
            else{
                if(stack.size()==0){
                    System.out.println(c);
                    System.out.println(stack);
                    return false;
                }
                if(open.get(stack.peek()).equals(close.get(c))){
                    stack.pop();
                }
                else{
                    System.out.println(c);
                    System.out.println(stack);
                    return false;
                }
            }
        }

        if(stack.size()!=0){
            return false;
        }

        return true;
    }
}
