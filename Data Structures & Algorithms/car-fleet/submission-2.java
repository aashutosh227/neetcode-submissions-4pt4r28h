class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        /**
        s1(2p2-p1+x) = s2(x)
        s1(2p2-p1)/(s2-s1) = x
        7 4 1 0
        **/

        Integer[] carIdx = new Integer[position.length];
        for(int i = 0; i<position.length; i++){
            carIdx[i] = i;
        }

        Arrays.sort(carIdx, (i1, i2) -> Integer.compare(position[i2],position[i1]));

        Deque<Double> fleet = new ArrayDeque<>();
        fleet.push((double)(target-position[carIdx[0]])/speed[carIdx[0]]);

        int fc = 0;
        for(int i = 1; i<carIdx.length; i++){
            int ci = carIdx[i];
            double ti = speed[ci] == 0 ? -1.3f : (double)(target-position[ci])/speed[ci];
            System.out.println(ti);
            System.out.println(fleet);
            
            if(ti==-1.0f){
                break;
            }
            if(fleet.peek()<ti){
                fleet.clear();
                fleet.push(ti);
                fc++;
            }
            else if(fleet.size()>0) {
                double top = fleet.pop();
                fleet.push(ti);
                fleet.push(top);
            }
        }

        if(fleet.size()>0){
            fc++;
        }

        return fc;
    }
}
