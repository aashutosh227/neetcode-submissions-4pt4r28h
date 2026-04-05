class Solution {

    private class HeightNode {
        int startIndex;
        int height;

        HeightNode(int si, int h){
            this.startIndex = si;
            this.height = h;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Deque<HeightNode> hq = new ArrayDeque<>();
        int maxArea = 0;

        for(int i=0; i<heights.length; i++){
            if(hq.isEmpty()){
                hq.push(new HeightNode(i, heights[i]));
                continue;
            }

            if(hq.peek().height <= heights[i]){
                if(hq.peek().height == heights[i]){
                    hq.push(new HeightNode(hq.peek().startIndex, heights[i]));
                    continue;
                }
                hq.push(new HeightNode(i, heights[i]));
            }
            else{
                HeightNode hNode = hq.pop();
                while(hNode.height > heights[i]){
                    int breadth = i - hNode.startIndex;
                    int len = hNode.height;
                    if(len*breadth > maxArea){
                        maxArea = len*breadth;
                    }
                    
                    if(!hq.isEmpty()){
                        if(hq.peek().height < heights[i]){
                            break;
                        }
                        hNode = hq.pop();
                    }
                    else{
                        break;
                    }
                }
                
                hq.push(new HeightNode(hNode.startIndex, heights[i]));
            }
        }

        int leftOverSize = hq.size();
        // int overHead = 0;
        // if(leftOverSize > 0 && hq.peek().startIndex!=(leftOverSize-1)){
        //     overHead = hq.peek().startIndex - leftOverSize + 1;
        // }
        //             System.out.println(overHead);
        //             System.out.println(leftOverSize);
        System.out.println(hq);
        while(!hq.isEmpty()){
            HeightNode hNode = hq.pop();
            int l = hNode.height;
            int b = heights.length - hNode.startIndex;
            System.out.println(hNode.height+" "+hNode.startIndex);
            System.out.println(l+" "+b);
            if(maxArea<l*b){
                maxArea = l*b;
            }
        }

        return maxArea;
    }

}