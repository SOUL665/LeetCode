class Solution {
    public int heightChecker(int[] heights) {
        int[] normal = heights.clone();
        for(int i = 0;i < heights.length; i++){
            for(int j = 1; j < heights.length - i; j++){
                if(heights[j] < heights[j - 1]){
                    int temp = heights[j];
                    heights[j] = heights[j - 1];
                    heights[j - 1] = temp;
                }
            }
        }

        int count = 0;
        for(int k = 0; k < heights.length;k++){
            if(heights[k] != normal[k]){
                count++;
            }
        }
        return count;
    }
}