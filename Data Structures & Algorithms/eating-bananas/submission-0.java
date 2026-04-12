class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int m = piles[0];

       for(int i = 0; i < piles.length; i ++){
            if(piles[i]>m){
                m = piles[i];
            }
       }

       int l = 1;
       int r = m;
       int res = r;

       while(l<=r){

            int hrs = 0;
            int k = l+(r-l)/2;
            for(int i=0;i<piles.length;i++){
                // hrs+=Math.ceil((double) piles[i]/k);
                hrs+=(piles[i]+k-1)/k;
            }


            if(hrs<=h){
                // System.out.println(hrs);
                // System.out.println(k);
                res = Math.min(res, k);
                r = k - 1;
            }
            else{
                l = k+1;
            }
       }

       return res;
    }
}
