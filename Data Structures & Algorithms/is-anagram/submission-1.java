class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character, Long> sCt = s.chars()
        .mapToObj(c->(char)c)
        .collect(Collectors.groupingBy(c->c, Collectors.counting()));
        Map<Character, Long> tCt = t.chars()
        .mapToObj(c->(char)c)
        .collect(Collectors.groupingBy(c->c, Collectors.counting()));

        for(Map.Entry<Character, Long> e : sCt.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue() +" "+tCt.get(e.getKey()));
            if(!Objects.equals(tCt.get(e.getKey()), e.getValue())){
                return false;
            }
        }
        return true;

    }
}
