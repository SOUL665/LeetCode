class Solution {
    public int numDecodings(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();

        long prev2 = 1;
        long prev1 = waysOne(s.charAt(0));

        for (int i = 2; i <= n; i++) {
            char curr = s.charAt(i - 1);
            char prev = s.charAt(i - 2);

            long currentWays = (prev1 * waysOne(curr)) % MOD;
            currentWays = (currentWays + prev2 * waysTwo(prev, curr)) % MOD;

            prev2 = prev1;
            prev1 = currentWays;
        }

        return (int) prev1;
    }

    private int waysOne(char c) {
        if (c == '0') {
            return 0;
        }
        if (c == '*') {
            return 9;
        }
        return 1;
    }

    private int waysTwo(char c1, char c2) {
        if (c1 == '*' && c2 == '*') {
            return 15;
        }
        if (c1 == '*') {
            return (c2 <= '6') ? 2 : 1;
        }
        if (c2 == '*') {
            if (c1 == '1') {
                return 9;
            }
            if (c1 == '2') {
                return 6;
            }
            return 0;
        }

        int val = (c1 - '0') * 10 + (c2 - '0');
        return (val >= 10 && val <= 26) ? 1 : 0;
    }
}