class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        
        Set<Integer> intersectionSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersectionSet.add(num);
            }
        }
        
        int[] res = new int[intersectionSet.size()];
        int idx = 0;
        for (int num : intersectionSet) {
            res[idx++] = num;
        }
        return res;
    }
}