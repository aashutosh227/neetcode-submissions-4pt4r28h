class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length()<2){
            return s.length();
        }
        int st = 0;
        int e = 1;
        Set<Character> checker = new HashSet<>();
        int res = 1;
        checker.add(s.charAt(0));
        while(st<=e && e<s.length()){
            if(!checker.contains(s.charAt(e))){
                if(res<(e-st+1)){
                    res=e-st+1;
                }
                checker.add(s.charAt(e));
                e++;
            }
            else if(st==e){
                e++;
            }
            else{
                // if(Character.compare(s.charAt(st), s.charAt(e))!=0){
                //     checker.remove(s.charAt(st));
                // }
                checker.remove(s.charAt(st));
                st++;
            }

        }

        System.out.println(res);

        // if(e==s.length()){
        //     return e-st;
        // }

        return res;
    }
}
