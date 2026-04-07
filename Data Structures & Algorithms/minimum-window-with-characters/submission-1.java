class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return  "";
        }
        
        Map<Character, Integer> ctMap = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            ctMap.put(t.charAt(i), ctMap.getOrDefault(t.charAt(i), 0)+1);
        }

        Map<Character, Integer> ctMap1 = new HashMap<>();

        int l = 0;
        int rl = 0;
        int rr = 0;
        int minLen = s.length();
        int ti =0;
        boolean found = false;
        System.out.println(ctMap); 

        for(int r=0; r<s.length(); r++){
            ctMap1.put(s.charAt(r), ctMap1.getOrDefault(s.charAt(r), 0)+1);

            if(ctMap.containsKey(s.charAt(r)) && 
            ctMap1.get(s.charAt(r))==ctMap.get(s.charAt(r))){
                System.out.println(ctMap1);
                ti++;
            }

            while(ti==ctMap.size()){
                System.out.println(minLen);
                System.out.println(r + " "+l);
                if(r-l+1<=minLen){
                    minLen = r-l+1;
                    rl = l;
                    rr = r;
                }
                found = true;
                ctMap1.put(s.charAt(l), ctMap1.get(s.charAt(l))-1);
                if(ctMap.containsKey(s.charAt(l)) 
                && ctMap1.get(s.charAt(l)) < ctMap.get(s.charAt(l))){
                    ti--;
                }
                l++;
            }
            
        }

        if(!found){
            return "";
        }

        return s.substring(rl, rr+1);
    }
}
