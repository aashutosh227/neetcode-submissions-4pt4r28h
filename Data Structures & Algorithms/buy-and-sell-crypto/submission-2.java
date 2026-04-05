class Solution {
    public int maxProfit(int[] prices) {
        int maxVal = 0;

        if(prices.length<2){
            return 0;
        }
        int minLeft = prices[0];
        for(int i = 0, j=1; i<prices.length && j<prices.length ; j++){
            int currVal = prices[j] - prices[i];

            if(currVal>maxVal){
                maxVal = currVal;
            }
            else{
                if(minLeft > prices[j]){
                    i=j;
                    minLeft = prices[i];
                }
            }
        }

        return maxVal;
    }
}