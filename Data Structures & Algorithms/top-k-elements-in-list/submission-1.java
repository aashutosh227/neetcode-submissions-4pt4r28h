class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> countsMap = Arrays.stream(nums)
        .boxed()
        .collect(Collectors.groupingBy(i->i, Collectors.counting()));


        Map<Long, List<Integer>> freqBucket = new HashMap<>();

        for(Map.Entry<Integer,Long> e : countsMap.entrySet()){
            long count = e.getValue();
            int n = e.getKey();
            System.out.println(n + " "+count);

            freqBucket.putIfAbsent(count, new ArrayList<>());


            freqBucket.get(count).add(n);
            
        }
        System.out.println(freqBucket);
    
        List<Integer> rs = new ArrayList<>();
        
        for(int i=nums.length;i>0;i--){
            if(!freqBucket.containsKey((long)i)){
                continue;
            }
            System.out.println(freqBucket.get((long)i));
            
            rs.addAll(freqBucket.get((long)i));
            if(rs.size()>k){
                rs = rs.subList(0, k);
            }
            
            if(rs.size()==k){
                break;
            }
        }


        return rs.stream().mapToInt(i->i).toArray();
        
    }
}
