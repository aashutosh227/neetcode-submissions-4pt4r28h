class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffMap = new HashMap<>();
        int[] res;

        for(int i=0;i<nums.length;i++){
            diffMap.putIfAbsent(nums[i], i);
        }

        for(int i=0;i<nums.length;i++){
            if(Objects.nonNull(diffMap.get(target-nums[i])) && diffMap.get(target-nums[i])!=i){
                if(nums[i] == target-nums[i] && i>diffMap.get(target-nums[i])){
                    return new int[]{diffMap.get(target-nums[i]), i};
                }
                return new int[]{i, diffMap.get(target-nums[i])};
            }
        }

        return null;
    }
}
