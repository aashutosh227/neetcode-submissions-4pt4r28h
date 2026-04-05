class Solution {

    public String encode(List<String> strs) {
        String encodedStr="";
        for(String s:strs){
            encodedStr = encodedStr + s.length()+"#"+s;
        }
        System.out.println(encodedStr);
        return encodedStr;
    }

    public List<String> decode(String str) {
        String strSize = "";
        List<String> rs = new ArrayList<>();
        for(int i = 0;i< str.length(); i++){
            while(Character.compare(str.charAt(i), '#') != 0){
                strSize+=str.charAt(i);
                i++;
            }
            System.out.println(strSize);
            if(i!=str.length()){
                int strLen = Integer.parseInt(strSize);
                strSize = "";
                if(strLen<str.length()){
                    rs.add(str.substring(i+1, i+strLen+1));
                    i+=strLen;
                }
            }

        }
        return rs;
    }
}
