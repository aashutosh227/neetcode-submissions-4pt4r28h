class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int[] rs = new int[2];

       for(int l=0, r=numbers.length-1;l<r;){
            if(numbers[l]+numbers[r]==target){
                rs[0]=l+1;
                rs[1]=r+1;
                break;
            }
            else if (numbers[l]+numbers[r]>target){
                r--;
            }
            else{
                l++;
            }
       }
       return rs;
    }
}
