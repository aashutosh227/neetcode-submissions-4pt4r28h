class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] rs = new int[temperatures.length];
        if(temperatures.length==1){
            return rs;
        }
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);

        for(int i=1;i<temperatures.length;i++){
            
            while(temperatures[st.peek()] < temperatures[i]){
                int iTop = st.pop();
                rs[iTop] = i-iTop;

                if(st.isEmpty()){
                    break;
                }
            }

            st.push(i);
        }

        return rs;
    }
}
