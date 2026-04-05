class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];
        int j=0;

        for(int i=0;i<nums.length;i++){
            ans[i]=nums[j];
            ans[i+nums.length]=nums[j++];
        }

        return ans;
    }
}