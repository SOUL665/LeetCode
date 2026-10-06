class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] maxResult = new int[k];

        int start = Math.max(0, k - n);
        int end = Math.min(k, m);

        for (int i = start; i <= end; i++) {
            int[] sub1 = maxSubsequence(nums1, i);
            int[] sub2 = maxSubsequence(nums2, k - i);
            int[] merged = merge(sub1, sub2, k);

            if (isGreater(merged, 0, maxResult, 0)) {
                maxResult = merged;
            }
        }

        return maxResult;
    }

    private int[] maxSubsequence(int[] nums, int k) {
        int[] stack = new int[k];
        int top = 0;
        int drop = nums.length - k;

        for (int num : nums) {
            while (top > 0 && stack[top - 1] < num && drop > 0) {
                top--;
                drop--;
            }
            if (top < k) {
                stack[top++] = num;
            } else {
                drop--;
            }
        }

        return stack;
    }

    private int[] merge(int[] sub1, int[] sub2, int k) {
        int[] res = new int[k];
        int i = 0;
        int j = 0;

        for (int r = 0; r < k; r++) {
            if (isGreater(sub1, i, sub2, j)) {
                res[r] = sub1[i++];
            } else {
                res[r] = sub2[j++];
            }
        }

        return res;
    }

    private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] != nums2[j]) {
                return nums1[i] > nums2[j];
            }
            i++;
            j++;
        }
        return (nums1.length - i) > (nums2.length - j);
    }
}