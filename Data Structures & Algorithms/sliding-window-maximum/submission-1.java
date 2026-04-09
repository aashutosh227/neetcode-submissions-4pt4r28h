class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> rs = new ArrayList<>();

        int l = 0;
        int mi = 0;

        for(int r = 0;r<nums.length;r++){
            if(nums[mi]<nums[r]){
                mi = r;
            }

            if(r-l+1==k){
                rs.add(nums[mi]);
                
                int li = ++l;

                mi = li;
                while(li<=r){
                    if(nums[li]>nums[mi]){
                        mi = li;
                    }
                    li++;
                }
                
            }


        }

        return rs.stream().mapToInt(Integer::intValue).toArray();
    }
}
