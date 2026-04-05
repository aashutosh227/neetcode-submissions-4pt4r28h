class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];
        int j=0;

        for(int i=0;i<2*nums.length;i++){
            if(j==nums.length){
                j=0;
            }
            ans[i]=nums[j++];
        }

        return ans;
    }
}