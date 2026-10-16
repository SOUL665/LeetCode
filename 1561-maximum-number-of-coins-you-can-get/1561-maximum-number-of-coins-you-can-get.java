class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int total = 0;
        int n = piles.length / 3;

        for (int i = piles.length - 2; n > 0; i -= 2, n--) {
            total += piles[i];
        }

        return total;
    }
}