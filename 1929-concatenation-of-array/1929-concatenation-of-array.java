class Solution {
    public int[] getConcatenation(int[] nums) {
        int c =  nums.length;
        int[] ans = new int[2 * c];
        for(int i = 0; i < c; i++){
            ans[i] = nums[i];
            ans[i + c] = nums[i]; 
        }
        return ans;
    }
}