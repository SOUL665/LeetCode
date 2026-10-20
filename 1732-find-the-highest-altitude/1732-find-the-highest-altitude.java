class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int ans = 0;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum = sum + gain[i];
            ans = Math.max(sum , ans);
        }
        return ans;
    }
}