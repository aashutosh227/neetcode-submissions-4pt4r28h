class Solution {
    public int trap(int[] height) {
        if(height.length<=2){
            return 0;
        }

        int a = 0;
        int maxLeft=height[0];
        int maxRight=height[height.length-1];
        for(int i=0, j=height.length-1; i<=j;){
            int c;
            int m;
            if(maxLeft>=maxRight){
                c = j--;
                m = maxRight;
                if(maxRight<height[c]){
                    maxRight = height[c];
                }
            }else{
                c = i++;
                m=maxLeft;
                if(maxLeft<height[c]){
                    maxLeft = height[c];
                }
            }
            if(m - height[c]>0){
                a = a + m - height[c];
            }
        }

        return a;
    }

}
