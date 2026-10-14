class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];

        Comparator<Integer> cmp = (a, b) -> {
            if (nums[a] != nums[b]) {
                return Integer.compare(nums[a], nums[b]);
            }
            return Integer.compare(a, b);
        };

        TreeSet<Integer> left = new TreeSet<>(cmp);
        TreeSet<Integer> right = new TreeSet<>(cmp);

        for (int i = 0; i < n; i++) {
            left.add(i);
            right.add(left.pollLast());

            if (left.size() < (k + 1) / 2) {
                left.add(right.pollFirst());
            }

            if (i >= k - 1) {
                if (k % 2 == 1) {
                    result[i - k + 1] = (double) nums[left.last()];
                } else {
                    result[i - k + 1] = ((double) nums[left.last()] + (double) nums[right.first()]) / 2.0;
                }

                int removeIdx = i - k + 1;
                if (!left.remove(removeIdx)) {
                    right.remove(removeIdx);
                }

                if (left.size() < (k + 1) / 2 && !right.isEmpty()) {
                    left.add(right.pollFirst());
                }
            }
        }

        return result;
    }
}