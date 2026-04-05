class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> checker = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(checker.get(nums[i]) != null && checker.get(nums[i])){
                return true;
            }
            else{
                checker.put(nums[i], true);
            }
        }
        return false;
    }
}