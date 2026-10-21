class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxjump = 0;

        for(int i = 0; i < n; i++){
            if(i > maxjump){
                return false;
            }
            maxjump = Math.max(maxjump, i + nums[i]);
            if(maxjump >= n - 1){
                return true;
            }
        }
        return true;
    }
}