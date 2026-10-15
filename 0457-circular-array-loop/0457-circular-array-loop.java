class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }

            int slow = i;
            int fast = i;
            boolean forward = nums[i] > 0;

            while (true) {
                slow = getNext(nums, forward, slow);
                if (slow == -1) {
                    break;
                }

                fast = getNext(nums, forward, fast);
                if (fast == -1) {
                    break;
                }
                fast = getNext(nums, forward, fast);
                if (fast == -1) {
                    break;
                }

                if (slow == fast) {
                    return true;
                }
            }

            int curr = i;
            while (nums[curr] != 0 && (nums[curr] > 0) == forward) {
                int next = ((curr + nums[curr]) % n + n) % n;
                nums[curr] = 0;
                curr = next;
            }
        }

        return false;
    }

    private int getNext(int[] nums, boolean forward, int curr) {
        int n = nums.length;
        boolean direction = nums[curr] > 0;

        if (direction != forward) {
            return -1;
        }

        int next = ((curr + nums[curr]) % n + n) % n;
        if (next == curr) {
            return -1;
        }

        return next;
    }
}