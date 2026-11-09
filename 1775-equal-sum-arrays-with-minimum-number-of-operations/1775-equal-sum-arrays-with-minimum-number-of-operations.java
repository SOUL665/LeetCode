class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 * 6 < n2 || n2 * 6 < n1) {
            return -1;
        }

        int sum1 = 0;
        for (int x : nums1) {
            sum1 += x;
        }

        int sum2 = 0;
        for (int x : nums2) {
            sum2 += x;
        }

        if (sum1 > sum2) {
            return minOperations(nums2, nums1);
        }

        int diff = sum2 - sum1;
        if (diff == 0) {
            return 0;
        }

        int[] count = new int[6];

        for (int x : nums1) {
            count[6 - x]++;
        }
        for (int x : nums2) {
            count[x - 1]++;
        }

        int operations = 0;
        for (int gain = 5; gain >= 1; gain--) {
            if (diff <= 0) {
                break;
            }
            int take = Math.min(count[gain], (diff + gain - 1) / gain);
            operations += take;
            diff -= take * gain;
        }

        return operations;
    }
}