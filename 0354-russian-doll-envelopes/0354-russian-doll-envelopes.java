class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int[] tails = new int[envelopes.length];
        int len = 0;

        for (int[] env : envelopes) {
            int h = env[1];
            int left = 0;
            int right = len - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] >= h) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            tails[left] = h;
            if (left == len) {
                len++;
            }
        }

        return len;
    }
}