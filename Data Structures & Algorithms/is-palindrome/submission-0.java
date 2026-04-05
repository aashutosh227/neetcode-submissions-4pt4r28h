class Solution {
    public boolean isPalindrome(String s) {
        System.out.println(s.length());
        String s1 = "";
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                s1 = s1 + Character.toLowerCase(s.charAt(i));
            }
        }
        System.out.println(s1);
        for(int i=0, j=s1.length()-1;i<j;i++, j--){
            if(Character.compare(s1.charAt(i), s1.charAt(j))==0){
                continue;
            }
            return false;
        }
        return true;
    }
}
