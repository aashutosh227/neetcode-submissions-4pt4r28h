class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        Map<Character, Integer> ctMap = new HashMap<>();
        for(int i = 0; i<s1.length(); i++){
            ctMap.put(s1.charAt(i), ctMap.getOrDefault(s1.charAt(i), 0)+1);
        }
        int wLen = s1.length();

        int l=0;
        Map<Character, Integer> ctMap2 = new HashMap<>();
        for(int r = 0; r<s2.length(); r++){
            
            ctMap2.put(s2.charAt(r), ctMap2.getOrDefault(s2.charAt(r), 0)+1);

            if(r-l+1>s1.length()){
                ctMap2.put(s2.charAt(l), ctMap2.getOrDefault(s2.charAt(l), 0)-1);
                l++;
            }

            int mc = 0;
            for(Map.Entry<Character, Integer> e : ctMap2.entrySet()){
                if(e.getValue() == ctMap.get(e.getKey())){
                    mc++;
                }
            }

            if(mc==ctMap.size()){
                return true;
            }
            
        }

        return false;
    }
}
