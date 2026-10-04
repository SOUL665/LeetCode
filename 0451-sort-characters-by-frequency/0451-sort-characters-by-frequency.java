class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        List<Character>[] buckets = new List[s.length() + 1];
        for (int i = 0; i < 128; i++) {
            if (freq[i] > 0) {
                int count = freq[i];
                if (buckets[count] == null) {
                    buckets[count] = new ArrayList<>();
                }
                buckets[count].add((char) i);
            }
        }

        StringBuilder sb = new StringBuilder(s.length());
        for (int count = buckets.length - 1; count > 0; count--) {
            if (buckets[count] != null) {
                for (char c : buckets[count]) {
                    for (int i = 0; i < count; i++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}