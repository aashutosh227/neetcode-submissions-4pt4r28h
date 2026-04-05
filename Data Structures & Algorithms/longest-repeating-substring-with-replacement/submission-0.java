class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> countsMap = new HashMap<>();
        int res = 0, l =0 , maxF = 0;

        for(int r = 0;r<s.length(); r++){
            countsMap.put(s.charAt(r),countsMap.getOrDefault(s.charAt(r),0)+1);
            if(maxF<countsMap.get(s.charAt(r))){
                maxF = countsMap.get(s.charAt(r));
            }

            while((r-l+1)-maxF > k){
                countsMap.put(s.charAt(l),countsMap.getOrDefault(s.charAt(l),0)-1);
                l += 1;
            }

            res = Math.max(res, r-l+1);
        }

        return res;
        
    }
}
