class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);

        int prev = nums[0];
        int seqSize = 1;
        int maxSize = seqSize;
        for(int i=1; i<nums.length;i++){
            System.out.println(prev + "|" +nums[i] +"|"+seqSize+"|"+maxSize);
            if(prev+1==nums[i]){
                prev=nums[i];
                seqSize++;
            }
            else if(prev==nums[i]){
                if(i==nums.length-1 && seqSize>maxSize){
                maxSize=seqSize;
                break;
            }
                continue;
            }
            else{
                if(seqSize>maxSize){
                    maxSize=seqSize;
                }
                seqSize = 1;
                prev = nums[i];
            }

            if(i==nums.length-1 && seqSize>maxSize){
                maxSize=seqSize;
            }
        }

        return maxSize;

    }
}
