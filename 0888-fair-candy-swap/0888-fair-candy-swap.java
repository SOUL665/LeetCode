class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0;
        for (int a : aliceSizes) {
            sumA += a;
        }

        int sumB = 0;
        Set<Integer> bobSet = new HashSet<>();
        for (int b : bobSizes) {
            sumB += b;
            bobSet.add(b);
        }

        int delta = (sumB - sumA) / 2;

        for (int a : aliceSizes) {
            int targetB = a + delta;
            if (bobSet.contains(targetB)) {
                return new int[]{a, targetB};
            }
        }

        return new int[0];
    }
}