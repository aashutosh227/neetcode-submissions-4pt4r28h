class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;

        for(int i=0, j=heights.length-1;i<j;){
            // System.out.println(i+"|"+j+"|"+maxArea);
            // System.out.println((j-i)*Math.min(heights[j], heights[i]));
            if(maxArea<(j-i)*Math.min(heights[j], heights[i])){
                maxArea = (j-i)*Math.min(heights[j], heights[i]);
            }

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
