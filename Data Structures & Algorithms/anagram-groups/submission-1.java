class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resMap = new HashMap<>();

        for(String s:strs){
           char[] chars = s.toCharArray();
           Arrays.sort(chars);
           String key = Arrays.toString(chars);
           resMap.putIfAbsent(key, new ArrayList<>());
           resMap.get(key).add(s);

        }
        return new ArrayList<>(resMap.values());
    }
}
