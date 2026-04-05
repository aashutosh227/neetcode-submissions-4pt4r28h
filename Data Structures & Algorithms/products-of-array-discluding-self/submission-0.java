class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProducts = new int[nums.length];
        int[] suffixProducts = new int[nums.length];
        int[] rs = new int[nums.length];

        for(int i = 0;i<nums.length;i++){
            if(i==0){
                prefixProducts[i]=1;
                continue;
            }
            prefixProducts[i] = prefixProducts[i-1]*nums[i-1];
        }

        for(int i = nums.length-1;i>=0;i--){
            if(i==nums.length-1){
                suffixProducts[i] = 1;
                continue;
            }
            suffixProducts[i] = suffixProducts[i+1]*nums[i+1];
        }

        for(int i=0;i<nums.length;i++){
            rs[i] = prefixProducts[i]*suffixProducts[i];
        }

        return rs;
    }
}  
