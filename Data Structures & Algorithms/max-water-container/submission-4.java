class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;

        for(int i=0, j=heights.length-1;i<j;){
            int area  = (j-i)*Math.min(heights[j], heights[i]);
            maxArea = Math.max(maxArea, area);

            if(heights[j] > heights[i]){
                    i++;
                }
                else{
                    j--;
                }
        }

        return maxArea;
    }
}
