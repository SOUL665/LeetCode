class Solution {
    private static final int MOD = 1_000_000_007;

    public int rectangleArea(int[][] rectangles) {
        int n = rectangles.length;
        int[][] events = new int[2 * n][4];
        TreeSet<Integer> ySet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int x1 = rectangles[i][0];
            int y1 = rectangles[i][1];
            int x2 = rectangles[i][2];
            int y2 = rectangles[i][3];

            events[2 * i] = new int[]{x1, 1, y1, y2};
            events[2 * i + 1] = new int[]{x2, -1, y1, y2};

            ySet.add(y1);
            ySet.add(y2);
        }

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int[] yCoords = new int[ySet.size()];
        int idx = 0;
        for (int y : ySet) {
            yCoords[idx++] = y;
        }

        SegmentTree st = new SegmentTree(yCoords);
        long totalArea = 0;
        long lastX = events[0][0];

        for (int[] event : events) {
            long currX = event[0];
            int type = event[1];
            int y1 = event[2];
            int y2 = event[3];

            totalArea = (totalArea + (currX - lastX) * st.query()) % MOD;
            st.update(1, 0, yCoords.length - 1, y1, y2, type);
            lastX = currX;
        }

        return (int) totalArea;
    }

    private static class SegmentTree {
        private final int[] count;
        private final long[] total;
        private final int[] yCoords;

        public SegmentTree(int[] yCoords) {
            this.yCoords = yCoords;
            int m = yCoords.length;
            count = new int[4 * m];
            total = new long[4 * m];
        }

        public void update(int node, int l, int r, int y1, int y2, int val) {
            if (yCoords[r] <= y1 || yCoords[l] >= y2) {
                return;
            }

            if (y1 <= yCoords[l] && yCoords[r] <= y2) {
                count[node] += val;
            } else {
                int mid = l + (r - l) / 2;
                update(2 * node, l, mid, y1, y2, val);
                update(2 * node + 1, mid, r, y1, y2, val);
            }

            if (count[node] > 0) {
                total[node] = yCoords[r] - yCoords[l];
            } else {
                if (r - l == 1) {
                    total[node] = 0;
                } else {
                    total[node] = total[2 * node] + total[2 * node + 1];
                }
            }
        }

        public long query() {
            return total[1];
        }
    }
}