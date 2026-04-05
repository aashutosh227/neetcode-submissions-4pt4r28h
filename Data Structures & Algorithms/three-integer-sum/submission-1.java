class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> rs = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            int t = -nums[i];
            int si = i+1;
            if(si==nums.length){
                break;
            }
            ArrayList<Integer>[] pRs = isTriplet(nums, si, t);
            int j = 0;
            while(j<nums.length && pRs[j]!=null && pRs[j].size()==2){
                List<Integer> subList = new ArrayList<>();
                subList.add(nums[i]);
                subList.add(pRs[j].get(0));
                subList.add(pRs[j++].get(1));
                rs.add(subList);
            }

        }

        return new ArrayList<>(rs);

    }

    private ArrayList<Integer>[] isTriplet(int[] nums,int si, int target){
        ArrayList<Integer>[] rs = new ArrayList[nums.length];
        if(si==nums.length-1){
            return rs;
        }

        for(int i=si, j=nums.length-1, k=0;i<j;){
            List<Integer> pRs = new ArrayList<>();
            if(nums[i]+nums[j]>target){
                j--;
            }
            else if(nums[i]+nums[j]<target){
                i++;
            }
            else if(nums[i]+nums[j]==target){
                if(k==nums.length){
                    break;
                }
                System.out.println(target +"|"+nums[i]+"|"+nums[j]);
                rs[k] = new ArrayList<Integer>();
                rs[k].add(nums[i]);
                rs[k++].add(nums[j]);
                i++;
                j--;
            }
        }
        return rs;
    }
}
