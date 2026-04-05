class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] visited = new int[strs.length];
        List<List<String>> res = new ArrayList<>();

        for(int i=0;i<strs.length;i++){
            if(visited[i]==1){
                continue;
            }
            List<String> partialRes = new ArrayList<>(); 
            String s1 = strs[i];
            partialRes.add(s1);
            visited[i]=1;
            int k = 1;
            
            for(int j=i+1;j<strs.length;j++){
                if(visited[j]==1){
                    continue;
                }
                String s2 = strs[j];
                if(checkAnagrams(s1, s2)){
                    partialRes.add(s2);
                    visited[j]=1;
                }
            }

            res.add(partialRes);

        }
        return res;
    }

    public boolean checkAnagrams(String s1,  String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        int[] freq = new int[26];

        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }

        for(int ct : freq){
            if(ct!=0){
                return false;
            }
        }
        return true;
    }
}
