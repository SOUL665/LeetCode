class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        

        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            int ans = 0;
            for(int j = 0; j < n; j++){
                
                if(nums[i] > nums[j]){
                    ans++;
                    a[i] = ans;
                }
            }
        }
        return a;
    }
}