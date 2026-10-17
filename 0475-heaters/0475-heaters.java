class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int minRadius = 0;

        for (int house : houses) {
            int idx = Arrays.binarySearch(heaters, house);
            if (idx < 0) {
                idx = -(idx + 1);
            }

            int dist1 = (idx < heaters.length) ? heaters[idx] - house : Integer.MAX_VALUE;
            int dist2 = (idx > 0) ? house - heaters[idx - 1] : Integer.MAX_VALUE;

            minRadius = Math.max(minRadius, Math.min(dist1, dist2));
        }

        return minRadius;
    }
}