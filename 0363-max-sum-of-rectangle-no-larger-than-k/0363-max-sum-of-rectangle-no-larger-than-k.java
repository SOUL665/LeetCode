class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = Integer.MIN_VALUE;

        boolean rowMajor = m <= n;
        int outerLimit = rowMajor ? m : n;
        int innerLimit = rowMajor ? n : m;

        for (int i = 0; i < outerLimit; i++) {
            int[] sum = new int[innerLimit];
            for (int j = i; j < outerLimit; j++) {
                for (int c = 0; c < innerLimit; c++) {
                    sum[c] += rowMajor ? matrix[j][c] : matrix[c][j];
                }

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int currentSum = 0;

                for (int val : sum) {
                    currentSum += val;
                    Integer target = set.ceiling(currentSum - k);
                    if (target != null) {
                        result = Math.max(result, currentSum - target);
                        if (result == k) {
                            return k;
                        }
                    }
                    set.add(currentSum);
                }
            }
        }

        return result;
    }
}