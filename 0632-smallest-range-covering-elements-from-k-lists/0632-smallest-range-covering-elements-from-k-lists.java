class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0});
            max = Math.max(max, val);
        }

        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        while (minHeap.size() == nums.size()) {
            int[] curr = minHeap.poll();
            int min = curr[0];
            int listIdx = curr[1];
            int elemIdx = curr[2];

            if ((long) max - min < (long) rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }

            if (elemIdx + 1 < nums.get(listIdx).size()) {
                int nextVal = nums.get(listIdx).get(elemIdx + 1);
                minHeap.offer(new int[]{nextVal, listIdx, elemIdx + 1});
                max = Math.max(max, nextVal);
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }
}