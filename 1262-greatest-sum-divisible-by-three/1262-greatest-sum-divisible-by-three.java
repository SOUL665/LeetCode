class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : nums) {
            int[] nextDp = dp.clone();
            for (int r = 0; r < 3; r++) {
                if (dp[r] != Integer.MIN_VALUE) {
                    int nextRem = (r + num) % 3;
                    nextDp[nextRem] = Math.max(nextDp[nextRem], dp[r] + num);
                }
            }
            dp = nextDp;
        }

        return dp[0];
    }
}