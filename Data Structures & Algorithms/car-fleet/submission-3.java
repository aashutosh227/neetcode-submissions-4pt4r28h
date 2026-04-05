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

        double fleetTime = (double)(target-position[carIdx[0]])/speed[carIdx[0]];

        int fc = 0;
        int fs = 1;
        for(int i = 1; i<carIdx.length; i++){
            int ci = carIdx[i];
            double ti = speed[ci] == 0 ? -1.3f : (double)(target-position[ci])/speed[ci];
            System.out.println(ti);
            
            if(ti==-1.0f){
                fs = 0;
                break;
            }
            if(fleetTime<ti){
                fleetTime = ti;
                fc++;
                fs=1;
            }
            else{
                fs++;
            }
        }

        if(fs>0){
            fc++;
        }

        return fc;
    }
}
